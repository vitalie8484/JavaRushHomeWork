package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream fis1 = new FileInputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);
        FileOutputStream fos3 = new FileOutputStream(file3);

        int med = fis1.available()/2;

        while(fis1.available() > 0) {
            if (fis1.available() <= med)
                fos3.write(fis1.read());
            else
                fos2.write(fis1.read());
        }

        fis1.close();
        fos2.close();
        fos3.close();
    }
}
