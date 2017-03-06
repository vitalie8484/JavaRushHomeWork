package com.javarush.test.level08.lesson08.task04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");

        for (Map.Entry<String, Date> pair : map.entrySet()) {
            String s = pair.getKey();
            Date d = pair.getValue();
            System.out.println(s + " - " + format.format(d));
        }

        removeAllSummerPeople(map);

        System.out.println("------------");

        for (Map.Entry<String, Date> pair : map.entrySet()) {
            String s = pair.getKey();
            Date d = pair.getValue();
            System.out.println(s + " - " + format.format(d));
        }
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Name1", new Date("JUNE 1 1980"));
        map.put("Name2", new Date("MAY 25 1985"));
        map.put("Name3", new Date("FEBRUARY 5 1985"));
        map.put("Name4", new Date("JANUARY 48 1990"));
        map.put("Name5", new Date("SEPTEMBER 6 1983"));
        map.put("Name6", new Date("AUGUST 1 1980"));
        map.put("Name7", new Date("JULY 28 1992"));
        map.put("Name8", new Date("FEBRUARY 3 1980"));
        map.put("Name9", new Date("DECEMBER 16 1989"));
        map.put("Name10", new Date("JUNE 1 1980"));

        //напишите тут ваш код

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        HashMap<String, Date> copyMap = new HashMap<>(map);

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            String s = pair.getKey();
            Date d = pair.getValue();
            int i = d.getMonth();
            if (4 < i && i < 8)
                iterator.remove();
        }

    }
}
