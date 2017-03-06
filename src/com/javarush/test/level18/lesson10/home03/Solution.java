package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream f1 = null;
        FileInputStream f2 = null;
        FileInputStream f3 = null;
        BufferedWriter output = null;
        try {
            String file1 = reader.readLine();
            f1 = new FileOutputStream(file1);
            f2 = new FileInputStream(reader.readLine());
            f3 = new FileInputStream(reader.readLine());

            while (f2.available() > 0) {
                int i = f2.read();
                f1.write(i);
            }

            f1.flush();
            f1.close();

            output = new BufferedWriter(new FileWriter(file1, true));
            output.append(System.lineSeparator());

            while (f3.available() > 0) {
                output.append((char) f3.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                f1.close();
                f2.close();
                f3.close();
                reader.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
