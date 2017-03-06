package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 100000; i++)
        {
            words.add(String.valueOf(i));
        }

        Date date1 = new Date();
        Map<String, Integer> map = countWords1(words);
        Date date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());

        date1 = new Date();
        Map<String, Integer> map2 = countWords2(words);
        date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());

        /*
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        */
    }

    public static Map<String, Integer> countWords1(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код
        HashSet<String> setList = new HashSet<>();
        setList.addAll(list);

        for (String str : setList)
            result.put(str, 0);

        for (String str : list) {
            if (result.containsKey(str))
                result.put(str, result.get(str) + 1);
        }

        return result;
    }

    public static Map<String, Integer> countWords2(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (int i = 0; i < list.size(); i++) {
            if (result.containsKey(list.get(i)))
                result.put(list.get(i), result.get(list.get(i)) + 1);
            else
                result.put(list.get(i), 1);
        }

        return result;
    }

}
