package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream is=System.in;
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        String str=br.readLine();
        int years=Integer.parseInt(str);
        String name=br.readLine();
        System.out.println(name+" захватит мир через "+years+" лет. Му-ха-ха!");

    }
}