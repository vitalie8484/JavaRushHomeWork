package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) {
        HashSet<Integer> set = createSet();

        for (Integer i : set)
            System.out.println(i);

        set = removeAllNumbersMoreThan10(set);

        for (Integer i : set)
            System.out.println(i);

    }

    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }

        return (HashSet<Integer>) set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        HashSet<Integer> copy = new HashSet<>(set);
        for (Integer i : set)
            if (i > 10)
                copy.remove(i);

        return copy;
    }
}
