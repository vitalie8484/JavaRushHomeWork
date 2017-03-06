package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("LastName1", "FirstName1");
        map.put("LastName2", "FirstName2");
        map.put("LastName3", "FirstName3");
        map.put("LastName4", "FirstName4");
        map.put("LastName5", "FirstName5");
        map.put("LastName6", "FirstName6");
        map.put("LastName7", "FirstName7");
        map.put("LastName8", "FirstName8");
        map.put("LastName9", "FirstName9");
        map.put("LastName10", "FirstName1");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);

        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String v = pair.getValue();
            iterator.remove();
            if (copy.containsValue(v))
                removeItemFromMapByValue(map, v);
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
