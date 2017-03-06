package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file1, file2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();

            Reader in = new FileReader(file1);
            Writer out = new FileWriter(file2);

            while (in.ready()) {
                char c = (char) in.read();
                if (c == '.')
                    c = '!';
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
