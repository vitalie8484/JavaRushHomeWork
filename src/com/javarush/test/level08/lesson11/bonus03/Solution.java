package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20000];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(new Random().nextInt());
        }

            sort(array);

        /*
        for (String x : array)
        {
            System.out.println(x);
        }
        */
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        Date date1 = new Date();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    String s = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = s;
                }
            }
        }
        Date date2 = new Date();

        System.out.println(date2.getTime() - date1.getTime());

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, array);

        date1 = new Date();
        Collections.sort(list);
        date2 = new Date();

        System.out.println(date2.getTime() - date1.getTime());
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
