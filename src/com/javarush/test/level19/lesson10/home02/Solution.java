package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        Reader read = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(read);

        Map<String, Double> values = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] vals = line.split(" ");
            if (values.containsKey(vals[0]))
                values.put(vals[0], Double.parseDouble(vals[1]) + values.get(vals[0]));
            else
                values.put(vals[0], Double.parseDouble(vals[1]));
        }

        double d = Collections.max(values.values());

        for (Map.Entry<String , Double> pair : values.entrySet()) {
            if (pair.getValue() == d)
                System.out.println(pair.getKey());
        }

        reader.close();
        read.close();
    }
}
