package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());

        List<Integer> i1Div = devides(i1);
        List<Integer> i2Div = devides(i2);

        List<Integer> common = new ArrayList<>(i1Div);

        common.retainAll(i2Div);

        int rez = 1;
        for (Integer i : common)
            rez *= i;

        System.out.println(rez);

    }

    public static List<Integer> devides(int i) {
        List<Integer> list = new ArrayList<>();

        for (int l = 1; l <= i; l++) {
            if (i % l == 0)
                list.add(l);
        }

        return list;
    }

}
