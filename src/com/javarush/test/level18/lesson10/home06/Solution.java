package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String f = args[0];
        InputStream in = null;
        BufferedInputStream bin = null;
        Map<Character, Integer> rez = new TreeMap<>();

        try {
            in = new FileInputStream(f);
            bin = new BufferedInputStream(in);

            while (bin.available() > 0) {
                char c = (char) bin.read();
                if (rez.containsKey(c))
                    rez.put(c, rez.get(c) + 1);
                else
                    rez.put(c, 1);
            }

            for (Map.Entry<Character, Integer> pair : rez.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                bin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
