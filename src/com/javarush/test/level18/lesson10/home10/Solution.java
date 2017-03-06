package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> files = new TreeMap<>();

        FileOutputStream out = null;
        BufferedOutputStream output = null;
        FileInputStream in = null;

        String file = null;

        try {
            while (true) {
                file = reader.readLine();
                if (file.equals("end"))
                    break;
                else {
                    files.put(Integer.parseInt(file.substring(file.lastIndexOf(".part") + 5, file.length())), file);
                }
            }

            out = new FileOutputStream(files.get(1).substring(0, files.get(1).lastIndexOf(".")));
            output = new BufferedOutputStream(out);

            byte[] buffer = new byte[1000];
            for (Map.Entry<Integer, String> pair : files.entrySet()) {
                in = new FileInputStream(pair.getValue());
                while (in.available() > 0) {
                    int i = in.read(buffer);
                    output.write(buffer, 0, i);
                }
            }

            output.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                output.close();
                out.close();
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
