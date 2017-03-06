package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};

        array = sort(array);

        System.out.println(Arrays.toString(array));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] secondArray = array;
        Arrays.sort(secondArray);

        double median = 0;
        if(secondArray.length % 2 != 0)
            median = secondArray[secondArray.length / 2];
        else {
            int m1 = secondArray[secondArray.length / 2];
            int m2 = secondArray[(secondArray.length / 2) - 1];
            median = (m1 + m2) / 2;
        }

        final double finalMedian = median;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double rez = Math.abs(o1 - finalMedian) - Math.abs(o2 - finalMedian);
                return rez == 0 ? o1 - o2 : (int) rez;
            }
        };

        Arrays.sort(array, comparator);

        return array;
    }
}
