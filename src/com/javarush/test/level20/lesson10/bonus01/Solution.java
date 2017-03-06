package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[] getNumbers(int N) {
        int[] result = null;

        List<Integer> rez = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int s = i;
            int p = String.valueOf(i).length();

            do {
                int prod = 1;
                int cifra = s % 10;
                for (int i1 = 1; i1 <= p; i1++)
                    prod *= cifra;
                sum += prod;
            } while ((s = (s / 10)) > 0);

            if (i == sum)
                rez.add(i);
        }

        result = new int[rez.size()];
        for (int i = 0; i < rez.size(); i++)
            result[i] = rez.get(i);

        return result;
    }
}
