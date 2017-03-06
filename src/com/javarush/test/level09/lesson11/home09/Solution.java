package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        map.put("Cat1", new Cat("cat_1"));
        map.put("Cat2", new Cat("cat_2"));
        map.put("Cat3", new Cat("cat_3"));
        map.put("Cat4", new Cat("cat_4"));
        map.put("Cat5", new Cat("cat_5"));
        map.put("Cat6", new Cat("cat_6"));
        map.put("Cat7", new Cat("cat_7"));
        map.put("Cat8", new Cat("cat_8"));
        map.put("Cat9", new Cat("cat_9"));
        map.put("Cat10", new Cat("cat_10"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> catName = new HashSet();

        catName.addAll(map.values());

        return catName;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
