package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner=new Scanner(System.in);
        String name1=scanner.nextLine();
        String name2=scanner.nextLine();
        String name3=scanner.nextLine();
        System.out.println(name1+" + "+name2+" + "+name3+" = Чистая любовь, да-да!");

    }
}