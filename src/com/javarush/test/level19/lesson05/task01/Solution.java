package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = null;
        OutputStream out = null;
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            in = new FileInputStream(file1);
            out = new FileOutputStream(file2);
            int par = 1;

            while (in.available() > 0) {
                if ((par % 2) == 0)
                    out.write(in.read());
                else
                    in.read();
                par++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
