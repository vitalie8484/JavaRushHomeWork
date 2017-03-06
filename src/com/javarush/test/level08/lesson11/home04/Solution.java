package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        //List<Integer> integerList = getIntegerList();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            integerList.add(new Random().nextInt(500));
        }

        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        int min1, min2;

        Date date1 = new Date();
        min1 = Collections.min(array);
        Date date2 = new Date();

        min2 = Integer.MAX_VALUE;
        Date date3 = new Date();
        for (int i = 0; i < array.size(); i++) {
            if (min2 < array.get(i))
                min2 = array.get(i);
        }
        Date date4 = new Date();

        System.out.println(date2.getTime() - date1.getTime());
        System.out.println(date4.getTime() - date3.getTime());

        return min1;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        ArrayList<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            result.add(scanner.nextInt());
        }

        return result;
    }
}
