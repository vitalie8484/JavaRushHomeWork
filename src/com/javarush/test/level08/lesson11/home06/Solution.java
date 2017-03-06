package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> family = new ArrayList<>();

        Human child1 = new Human("Child_1", true, 2);
        Human child2 = new Human("Child_2", false, 5);
        Human child3 = new Human("Child_3", true, 8);
        Human father = new Human("Father", true, 31, new ArrayList<Human>(Arrays.asList(child1, child2, child3)));
        Human mother = new Human("Mother", false, 29, new ArrayList<Human>(Arrays.asList(child1, child2, child3)));
        Human grandfather1 = new Human("Grandfather1", true, 54, new ArrayList<Human>(Arrays.asList(father)));
        Human grandmother1 = new Human("Grandmother1", false, 50, new ArrayList<Human>(Arrays.asList(father)));
        Human grandfather2 = new Human("Grandfather2", true, 61, new ArrayList<Human>(Arrays.asList(mother)));
        Human grandmother2 = new Human("Grandmother2", false, 54, new ArrayList<Human>(Arrays.asList(mother)));

        family.add(grandfather1);
        family.add(grandmother1);
        family.add(grandfather2);
        family.add(grandmother2);
        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        for (Human h : family) {
            System.out.println(h);
        }
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this(name, sex, age);
            this.children.addAll(children);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
