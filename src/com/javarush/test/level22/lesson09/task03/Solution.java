package com.javarush.test.level22.lesson09.task03;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = null;
        String line;
        StringBuilder text = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            boolean isFirstLine = true;
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    text.append(line);
                    isFirstLine = false;
                } else
                    text.append(" ").append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] words = text.toString().split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals("") || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder result = new StringBuilder();

        Map<String, Point> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            Point values = new Point();
            int x = 0;
            int y = 0;

            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (Character.toLowerCase(key.charAt(0)) == Character.toLowerCase(words[j].charAt(words[j].length() - 1)))
                        x++;
                    if (Character.toLowerCase(key.charAt(key.length() - 1)) == Character.toLowerCase(words[j].charAt(0)))
                        y++;
                }
            }
            values.setLocation(x, y);
            map.put(key, values);
        }

        String firstKey = "";
        int minValue = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, Point>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Point> pair = itr.next();
            String key = pair.getKey();
            Point values = pair.getValue();
            if (values.getY() < minValue) {
                minValue = (int) values.getY();
                firstKey = key;
            }
        }

        result.append(firstKey);
        map.remove(firstKey);

        while (map.size() > 0) {
            Character charToRemove = null;
            Iterator<Map.Entry<String, Point>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Point> pair = iterator.next();
                String key = pair.getKey();
                Point values = pair.getValue();
                if (map.size() > 1) {
                    if ((Character.toLowerCase(key.charAt(key.length() - 1)) == Character.toLowerCase(result.charAt(0))) &&
                            (values.getX() != 0)) {
                        charToRemove = Character.toLowerCase(key.charAt(key.length() - 1));
                        result.insert(0, " ").insert(0, key);
                        iterator.remove();
                        break;
                    }
                } else if (map.size() == 1) {
                    result.insert(0, " ").insert(0, key);
                    map.remove(key);
                }
            }

            if (charToRemove != null) {
                Iterator<Map.Entry<String, Point>> iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Point> pair = iter.next();
                    String key = pair.getKey();
                    Point values = pair.getValue();
                    if (charToRemove == Character.toLowerCase(key.charAt(0))) {
                        if (values.getX() > 0) {
                            values.setLocation(values.getX() - 1, values.getY());
                        }
                    }
                }
            }
        }

        /*
        for (Map.Entry<String, Point> pair : map.entrySet()) {
            System.out.println(pair.getValue().getX() + " - " + pair.getKey() + " - " + pair.getValue().getY());
        }
        */
        return result;
    }
}
