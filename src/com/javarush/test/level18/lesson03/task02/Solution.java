package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int minByte = Integer.MAX_VALUE;
        int currentByte;

        FileInputStream fis = new FileInputStream(fileName);

        while (fis.available() > 0) {
            currentByte = fis.read();
            if (minByte > currentByte)
                minByte = currentByte;
        }

        System.out.println(minByte);

        reader.close();
        fis.close();
    }
}
