package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String filename;

        filename = reader.readLine();

        while(true) {
            String s = reader.readLine();
            sb.append(s).append(System.getProperty("line.separator"));
            if (s.equals("exit"))
                break;
        }

        String result = sb.toString();

        byte[] b = result.getBytes();

        OutputStream os = new FileOutputStream(filename);

        os.write(b, 0, b.length - 1);

        os.flush();

        os.close();
    }
}
