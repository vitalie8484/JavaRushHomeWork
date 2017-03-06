package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        Reader read = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(read);

        Writer write = new FileWriter(args[1]);
        BufferedWriter writer = new BufferedWriter(write);

        String line;
        boolean firstWord = true;
        while ((line = reader.readLine()) != null) {
            String[] arr = line.split(" ");
            for (int i = 0; i < arr.length; i++)
                if (arr[i].length() > 6)
                    if (firstWord) {
                        writer.write(arr[i]);
                        firstWord = false;
                    } else {
                        writer.write(",");
                        writer.write(arr[i]);
                    }

        }

        reader.close();
        read.close();
        writer.close();
        write.close();

    }
}
