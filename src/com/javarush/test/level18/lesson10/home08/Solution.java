package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            try {
                String str = reader.readLine();
                if (str.equals("exit"))
                    break;
                else {
                    Thread readThread = new ReadThread(str);
                    readThread.start();
                    try {
                        readThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                //break;
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> result = new TreeMap<>();
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream in = null;
            try {
                in = new FileInputStream(fileName);
                while (in.available() > 0) {
                    int i = in.read();
                    if (result.containsKey(i))
                        result.put(i, result.get(i) + 1);
                    else
                        result.put(i, 1);
                }
                int max = Integer.MIN_VALUE;
                int rezByte = 0;
                for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
                    if (pair.getValue() >= max) {
                        max = pair.getValue();
                        rezByte = pair.getKey();
                    }
                }
                resultMap.put(fileName, rezByte);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
