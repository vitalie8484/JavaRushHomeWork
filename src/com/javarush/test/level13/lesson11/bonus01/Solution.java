package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileReader fileReader = new FileReader(file);
        BufferedReader fileBuffer = new BufferedReader(fileReader);

        ArrayList<Integer> list = new ArrayList<>();

        while(fileBuffer.ready()) {
            list.add(Integer.parseInt(fileBuffer.readLine()));
        }

        List<Integer> result = new ArrayList<>();

        for (Integer i : list)
            if(i % 2 == 0)
                result.add(i);

        Collections.sort(result);

        for (Integer i : result)
            System.out.println(i);

    }
}
