package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader resder = new BufferedReader(new InputStreamReader(System.in));

        String fileName = resder.readLine();

        FileInputStream fis = new FileInputStream(fileName);

        Set<Integer> byteSet = new TreeSet<>();

        while(fis.available() > 0) {
            byteSet.add(fis.read());
        }

        for (Integer i : byteSet)
            System.out.print(i + " ");

        resder.close();
        fis.close();
    }
}
