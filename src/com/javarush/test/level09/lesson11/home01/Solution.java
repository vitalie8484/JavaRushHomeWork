package com.javarush.test.level09.lesson11.home01;

/* Деление на ноль
Создай метод public static void divisionByZero, в котором подели любое число на ноль и выведи на экран результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя метод exception.printStackTrace()
*/

public class Solution {

    public static void main(String[] args) {
        divisionByZero();
    }

    public static void divisionByZero() {
        int a = 10, b = 0;
        try {
            int c = a / b;
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
    }
}
