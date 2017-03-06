package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        Reader read = null;
        BufferedReader reader = null;

        try {
            fileName = args[0];
            read = new FileReader(fileName);
            reader = new BufferedReader(read);

            Map<String, Double> values = new TreeMap<>();
            String line;
            String[] pair;

            while ((line = reader.readLine()) != null) {
                pair = line.split(" ");
                if (values.containsKey(pair[0]))
                    values.put(pair[0], values.get(pair[0]) + Double.parseDouble(pair[1]));
                else
                    values.put(pair[0], Double.parseDouble(pair[1]));
            }

            for (Map.Entry<String, Double> rez : values.entrySet()) {
                System.out.println(rez.getKey() + " " + rez.getValue());
            }
        } catch (Exception e) {
        } finally {
            try {
                reader.close();
                read.close();
            } catch (IOException e) {
            }
        }

    }
}