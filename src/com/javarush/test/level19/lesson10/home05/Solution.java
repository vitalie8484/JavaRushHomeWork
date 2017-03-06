package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String file1Name = args[0];
        String file2Name = args[1];

        String content = "";
        String line;
        Reader read = new FileReader(file1Name);
        BufferedReader reader = new BufferedReader(read);

        while ((line = reader.readLine()) != null)
            content += line;

        content = content.replaceAll(System.lineSeparator(), " ");
        String[] arrcontent = content.split(" ");

        Writer write = new FileWriter(file2Name);
        BufferedWriter writer = new BufferedWriter(write);

        boolean firstWord = true;
        for (int i = 0; i < arrcontent.length; i++) {
            if (arrcontent[i].matches(".*\\d+.*"))
                if (firstWord) {
                    writer.write(arrcontent[i]);
                    firstWord = false;
                }
                else
                    writer.write(" " + arrcontent[i]);
        }

        reader.close();
        writer.close();
        read.close();
        write.close();
    }
}
