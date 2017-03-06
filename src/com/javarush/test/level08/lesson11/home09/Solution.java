package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    static SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy");

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.println(s + " = " + isDateOdd(s));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        //Date date1 = new Date();
        //System.out.println(format.format(date1));
        Date data1 = format.parse(date);
        //System.out.println(format.format(data1));
        Date data2 = format.parse(date);

        data1.setMonth(0);
        data1.setDate(1);
        data1.setHours(0);
        data1.setMinutes(0);
        data1.setSeconds(0);

        long milisecDay = 24 * 60 * 60 * 1000;

        int days = (int)  (1 + ((data2.getTime() - data1.getTime()) / milisecDay));

        //System.out.println(days);

        return (days % 2 == 0) ? false : true;
    }
}
