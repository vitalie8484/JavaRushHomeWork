package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getCondition(map));
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            String param = pair.getKey();
            String value = pair.getValue();
            if ((param != null)  && (value != null)) {
                if (first) {
                    first = false;
                    query.append(param).append(" = ").append("'").append(value).append("'");
                } else
                    query.append(" and ").append(param).append(" = ").append("'").append(value).append("'");
            }
        }
        return query;
    }
}
