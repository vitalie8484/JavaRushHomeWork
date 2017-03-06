package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sb = new StringBuilder(s);

        //напишите тут ваш код
        /*String[] str = s.split("\\s+");

        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
            if (i == str.length - 1)
                sb.append(str[i]);
            else
                sb.append(str[i]).append(" ");
        }
        s = sb.toString();*/

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0) {
                if (sb.charAt(0) != ' ')
                    sb.replace(0, 1, String.valueOf(Character.toUpperCase(sb.charAt(0))));
            } else {
                if (sb.charAt(i - 1) == ' ' && sb.charAt(i) != ' ')
                    sb.replace(i, i + 1, String.valueOf(Character.toUpperCase(sb.charAt(i))));
            }

        }


        System.out.println(sb);
    }


}
