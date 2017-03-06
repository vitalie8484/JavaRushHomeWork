package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int key = 19;
        String param = null, fileName = null, fileOutputName = null;
        if (args.length == 0)
            System.exit(0);
        else {
            param = args[0];
            fileName = args[1];
            fileOutputName = args[2];
        }

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(fileName);
            out = new FileOutputStream(fileOutputName);
            if (param.equals("-e")) {
                while (in.available() > 0)
                    out.write(in.read() + key);
            } else if (param.equals("-d")) {
                while ((in.available() > 0))
                    out.write(in.read() - key);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
