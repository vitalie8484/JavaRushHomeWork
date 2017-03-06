package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader reader = null;
        Reader in = null;
        String fileName;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            in = new FileReader(fileName);
            reader = new BufferedReader(in);
            StringBuilder sb = new StringBuilder();

            boolean first = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (first) {
                    sb.append(line);
                    first = false;
                } else
                    sb.append(" ").append(line);
            }

            String[] words = sb.toString().split(" ");

            for (int i = 0; i < words.length - 1; i++) {
                String word = words[i];
                String reverseWord = new StringBuilder(words[i]).reverse().toString();

                cont:
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].equals(reverseWord)) {
                        Iterator<Pair> iterator = result.iterator();
                        while (iterator.hasNext()) {
                            Pair pair = iterator.next();
                            if ((pair.first.equals(word) && pair.second.equals(reverseWord)) ||
                                    (pair.first.equals(reverseWord) && pair.second.equals(word))) {
                                continue cont;
                            }
                        }

                        Pair pair = new Pair();
                        pair.first = word;
                        pair.second = reverseWord;
                        result.add(pair);
                    }
                }

            }

            for (Pair pair : result)
                System.out.println(pair.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
