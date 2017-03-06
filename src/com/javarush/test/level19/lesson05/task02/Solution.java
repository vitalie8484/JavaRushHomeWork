package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        FileReader in = new FileReader(file);
        String s = "";
        int rez = 0;

        while (in.ready())
            s += String.valueOf((char) in.read()).toLowerCase();

        s = s.replaceAll("\\p{Punct}", " ");
        s = s.replaceAll(System.lineSeparator(), " ");

        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("world"))
                rez++;
        }

        System.out.println(rez);

        reader.close();
        in.close();
    }
}
