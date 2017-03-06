package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {
        String[] str = getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < str.length; i++)
            System.out.println(str[i]);
    }

    public static String [] getTokens(String query, String delimiter) {
        if ((query == null) || (query.isEmpty()))
            return null;

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(query, delimiter);

        while (token.hasMoreElements()) {
            list.add(token.nextToken());
        }

        return list.toArray(new String[list.size()]);
    }
}
