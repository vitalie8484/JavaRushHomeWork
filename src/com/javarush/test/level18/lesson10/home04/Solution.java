package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = null;
        OutputStream out = null;

        try {
            String f1 = reader.readLine();
            String f2 = reader.readLine();

            in = new FileInputStream(f1);
            int[] ch = new int[in.available()];
            for (int i = 0; i < ch.length; i++)
                ch[i] = in.read();
            in.close();

            in = new FileInputStream(f2);
            out = new FileOutputStream(f1);

            while (in.available() > 0) {
                out.write(in.read());
            }
            out.write(13);
            out.write(10);

            for (int i = 0; i < ch.length; i++)
                out.write(ch[i]);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
