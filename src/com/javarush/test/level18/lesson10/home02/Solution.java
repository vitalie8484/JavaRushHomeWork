package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        String arg1 = args[0];
        int spaces = 0, letters = 0;
        int i;
        InputStream is = null;

        try {
            is = new FileInputStream(arg1);
            while ((i = is.read()) > 0) {
                char ch = (char) i;
                if (ch == ' ')
                    spaces++;
                letters++;
            }
            DecimalFormat  df = new DecimalFormat("#0.00");
            df.setRoundingMode(RoundingMode.DOWN);
            System.out.println(df.format(0000045551145554.228));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
