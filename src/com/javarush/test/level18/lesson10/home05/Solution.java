package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Reader in = null;
        Writer out = null;

        try {
            String f1 = reader.readLine();
            String f2 = reader.readLine();

            in = new FileReader(f1);
            out = new FileWriter(f2);
            reader = new BufferedReader(in);

            String s;
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
            s = sb.toString();
            String[] str = s.split("\\s+");
            for (String st : str) {
                out.write(String.valueOf(Math.round(Double.parseDouble(st))));
                out.write(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
