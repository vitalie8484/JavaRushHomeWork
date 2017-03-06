package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        Map<Integer, Integer> minMap = new HashMap<>();

        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int currentByte = fis.read();
            if (minMap.containsKey(currentByte))
                minMap.put(currentByte, minMap.get(currentByte) + 1);
            else
                minMap.put(currentByte, 1);
        }

        int minByte = Collections.min(minMap.values());

        for (Map.Entry<Integer, Integer> pair : minMap.entrySet()) {
            if (pair.getValue() == minByte)
                System.out.println(pair.getKey() + " ");
        }

        reader.close();
        fis.close();
    }
}
