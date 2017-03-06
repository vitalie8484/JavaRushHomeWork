package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = null;
        String fileName = null;

        try {
            while (true) {
                try {
                    fileName = reader.readLine();
                    in = new FileInputStream(fileName);
                } catch (FileNotFoundException ex) {
                    System.out.println(fileName);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
