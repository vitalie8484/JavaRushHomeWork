package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        int num = 0;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(args[0]);
            int c;
            while ((c = fis.read()) > 0) {
                if (letters.contains((char) c + ""))
                    num++;
            }
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
