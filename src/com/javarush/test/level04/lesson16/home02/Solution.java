package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        if (n2 > n1 && n2 > n3)
            System.out.println(min(max(n2, n1), max(n1, n3)));
        else
            System.out.println(min(max(n1, n2), max(n2, n3)));
    }
}
