package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileInputStream fis = new FileInputStream(filename);

        Map<Integer, Integer> maxByte = new HashMap<>();
        int currentByte;

        while (fis.available() > 0) {
            currentByte = fis.read();
            if (maxByte.containsKey(currentByte))
                maxByte.put(currentByte, maxByte.get(currentByte) + 1);
            else
                maxByte.put(currentByte, 1);
        }

        int maxValue = Collections.max(maxByte.values());
        for (Map.Entry<Integer, Integer> pair : maxByte.entrySet()) {
            if (maxValue == pair.getValue())
                System.out.print(pair.getKey() + " ");
        }

        reader.close();
        fis.close();
    }
}
