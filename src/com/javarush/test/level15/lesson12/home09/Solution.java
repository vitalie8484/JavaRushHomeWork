package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        s = s.substring(s.indexOf('?') + 1);

        String[] array = s.split("&");
        ArrayList<String> values = new ArrayList<>();

        for (String str : array) {
            System.out.print(str.substring(0, str.contains("=") ? str.indexOf('=') : str.length()));
            System.out.print(" ");
            if (str.startsWith("obj")) {
                values.add(str.substring(str.indexOf('=') + 1));
            }
        }

        if (!values.isEmpty()) {
            System.out.println();
            for (String str : values) {
                try {
                    alert(Double.parseDouble(str));
                } catch (Exception ex) {
                    alert(str);
                }
                /*
                if (str.contains("."))
                    alert(Double.parseDouble(str));
                else
                    alert(str);
                */
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
