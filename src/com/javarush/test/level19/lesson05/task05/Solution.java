package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            Reader in = new FileReader(file1);
            Writer out = new FileWriter(file2);

            while (in.ready()) {
                char c = (char) in.read();
                if (!Pattern.matches("\\p{Punct}", String.valueOf(c)))
                    out.write((int) c);
            }

            reader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
