package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //Add your code here
        int i = 0;
        try {
            FileInputStream fis = new FileInputStream("d:\nuexista.txt");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        exceptions.add(new java.io.IOException());
        exceptions.add(new java.io.FileNotFoundException());
        exceptions.add(new java.text.ParseException("a", i));
        exceptions.add(new java.lang.ClassNotFoundException());
        exceptions.add(new java.lang.CloneNotSupportedException());
        exceptions.add(new java.lang.InstantiationException());
        exceptions.add(new java.lang.InterruptedException());
        exceptions.add(new java.lang.NoSuchMethodException());


    }
}
