package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.awt.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private int age;
        private boolean sex;
        private int height;
        private Color eyes;
        private boolean maried;
        ArrayList<Human> childs;

        public Human(int age) {
            this.age = age;
        }

        public Human(int age, boolean sex) {
            this(age);
            this.sex = sex;
        }

        public Human(boolean sex, int age) {
            this(age);
            this.sex = sex;
        }

        public Human(int age, boolean sex, int height) {
            this(age, sex);
            this.height = height;
        }

        public Human(int age, int height, boolean sex) {
            this(age, sex);
            this.height = height;
        }

        public Human(boolean sex, int age, int height) {
            this(age, sex);
            this.height = height;
        }

        public Human(int age, boolean sex, int height, Color eyes) {
            this(age, sex, height);
            this.eyes = eyes;
        }

        public Human(int age, int height, boolean sex, Color eyes) {
            this(age, sex, height);
            this.eyes = eyes;
        }


        public Human(int age, boolean sex, int height, Color eyes, boolean maried) {
            this(age, sex, height, eyes);
            this.maried = maried;
        }

        public Human(int age, boolean sex, int height, Color eyes, boolean maried, ArrayList<Human> childs) {
            this(age, sex, height, eyes, maried);
            this.childs = childs;
        }


    }
}
