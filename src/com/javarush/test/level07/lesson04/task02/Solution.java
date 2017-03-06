package com.javarush.test.level07.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Reader read = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(read);

        String[] array = new String[10];

        for (int i = 0; i < 9; i++) {
            array[i] = reader.readLine();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[array.length - i - 1]);
        }

    }
}