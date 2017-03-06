package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Reader in = null;
        String fileName = null;
        try {
            fileName = reader.readLine();

            String content = "";
            String tag = args[0];

            in = new FileReader(fileName);

            reader = new BufferedReader(in);

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    content += line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<Integer> start = new ArrayList<>();
            List<Integer> stop = new ArrayList<>();


            content = content.replaceAll(System.lineSeparator(), "");

            for (int index = content.indexOf("<".concat(tag)); index >= 0; index = content.indexOf("<".concat(tag), index + 1))
                if ("<".concat(tag).concat(">").equals(content.substring(content.indexOf("<".concat(tag)), content.indexOf("<".concat(tag)) + tag.length() + 2)) ||
                        "<".concat(tag).concat(" ").equals(content.substring(content.indexOf("<".concat(tag)), content.indexOf("<".concat(tag)) + tag.length() + 2)))
                    start.add(index);

            for (int index = content.indexOf("</".concat(tag).concat(">")); index >= 0; index = content.indexOf("</".concat(tag).concat(">"), index + 1))
                stop.add(index + 2 + tag.length());

            //System.out.println(start);
            //System.out.println(stop);

            Map<Integer, Boolean> points = new TreeMap<>();
            for (int i = 0; i < start.size(); i++) {
                points.put(start.get(i), true);
                points.put(stop.get(i), false);
            }

            //for (Map.Entry<Integer, Boolean> pair : points.entrySet())
             //   System.out.println(pair.getKey() + " " + pair.getValue());

            while (points.size() > 0) {
                Iterator<Map.Entry<Integer, Boolean>> iterator = points.entrySet().iterator();
                boolean newTag = true;
                int newStart = 0;
                int newStop = 0;
                int pas = 0;
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Boolean> pair = iterator.next();
                    if (newTag && pair.getValue()) {
                        newStart = pair.getKey();
                        newTag = false;
                        pas++;
                    } else if (pair.getValue())
                        pas++;
                    else {
                        newStop = pair.getKey();
                        pas--;
                    }
                    if (pas == 0) {
                        System.out.println(content.substring(newStart, newStop + 1));
                        points.remove(newStart);
                        points.remove(newStop);
                        break;
                    }
                }
            }
        } catch (IOException e) {
        } finally {
            try {
                reader.close();
                in.close();
            } catch (IOException e) {
            }
        }
    }
}

