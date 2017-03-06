package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        if (n1 >= n2 && n2 >= n3)
            System.out.println(n1 + " " + n2 + " " + n3);
        else if (n1 >= n2 && n2 <= n3)
            System.out.println(n1 + " " + n3 + " " + n2);
        else if (n1 <= n2 && n2 >= n3)
            System.out.println(n2 + " " + n1 + " " + n3);
        else if (n1 <= n2 && n1 >= n3)
            System.out.println(n2 + " " + n3 + " " + n1);
        else if (n1 <= n2 && n2 <= n3)
            System.out.println(n3 + " " + n2 + " " + n1);
        else if (n1 >= n2 && n1 <= n3)
            System.out.println(n3 + " " + n1 + " " + n2);

    }
}
