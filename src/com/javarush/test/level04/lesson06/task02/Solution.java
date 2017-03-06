package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        int v3 = scanner.nextInt();
        int v4 = scanner.nextInt();

        System.out.println((maxim(v1, v2) > maxim(v3, v4) ? maxim(v1, v2) : maxim(v3, v4)));
    }

    public static int maxim(int n1, int n2) {
        return (n1 > n2) ? n1 : n2;
    }
}
