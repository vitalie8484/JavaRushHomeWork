package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Name1", "LastName1");
        map.put("Name2", "LastName2");
        map.put("Name3", "LastName3");
        map.put("Name4", "LastName4");
        map.put("Name5", "LastName5");
        map.put("Name6", "LastName6");
        map.put("Name7", "LastName7");
        map.put("Name8", "LastName8");
        map.put("Name9", "LastName9");
        map.put("Name10", "LastName10");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        if (map.containsValue(name)) {
            int i = 0;
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (pair.getValue().equals(name))
                    i++;
            }
            return i;
        } else
            return 0;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        if (map.containsKey(lastName)) {
            int i = 0;
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (pair.getKey().equals(lastName))
                    i++;
            }
            return i;
        } else
            return 0;

    }
}
