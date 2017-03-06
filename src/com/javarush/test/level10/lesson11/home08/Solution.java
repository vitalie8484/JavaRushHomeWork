package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] arrayLists = new ArrayList[3];

        arrayLists[0] = new ArrayList<>();
        arrayLists[0].add("str0_1");
        arrayLists[0].add("str0_2");
        arrayLists[0].add("str0_3");

        arrayLists[1] = new ArrayList<>();
        arrayLists[1].add("str1_1");

        arrayLists[2] = new ArrayList<>();
        arrayLists[2].add("str2_1");
        arrayLists[2].add("str2_2");
        arrayLists[2].add("str2_3");
        arrayLists[2].add("str2_4");
        arrayLists[2].add("str2_5");
        arrayLists[2].add("str2_6");

        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}