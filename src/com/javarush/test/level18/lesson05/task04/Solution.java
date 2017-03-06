package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] buff = new byte[fis.available()];
        byte[] buffRevers = new byte[fis.available()];
        fis.read(buff);

        for (int i = buff.length - 1; i >=0 ; i--) {
            buffRevers[buff.length - i - 1] = buff[i];
        }

        fos.write(buffRevers);

        fis.close();
        fos.close();
    }
}
