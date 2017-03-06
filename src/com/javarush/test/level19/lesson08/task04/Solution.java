package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream nativeOut = System.out;
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(arrayOut);

        System.setOut(myOut);
        testString.printSomething();
        System.setOut(nativeOut);

        String rez = arrayOut.toString();
        rez = rez.replaceAll(System.lineSeparator(), "");
        String[] op = rez.split(" ");

        if (op[1].equals("+")) {
            rez = rez + String.valueOf(Integer.parseInt(String.valueOf(op[0])) + Integer.parseInt(String.valueOf(op[2])));
        } else if (op[1].equals("-")) {
            rez = rez + String.valueOf(Integer.parseInt(String.valueOf(op[0])) - Integer.parseInt(String.valueOf(op[2])));
        } else if (op[1].equals("*")) {
            rez = rez + String.valueOf(Integer.parseInt(String.valueOf(op[0])) * Integer.parseInt(String.valueOf(op[2])));
        }

            System.out.println(rez);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

