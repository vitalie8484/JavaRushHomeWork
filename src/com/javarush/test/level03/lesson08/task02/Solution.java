package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String name=reader.readLine();
        String str=reader.readLine();
        int i1=Integer.parseInt(str);
        str=reader.readLine();
        int i2=Integer.parseInt(str);
        System.out.println(name+" получает "+i1+" через "+i2+" лет.");

    }
}