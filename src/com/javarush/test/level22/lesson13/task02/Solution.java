package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            String file1 = args[0];
            String file2 = args[1];

            try (FileInputStream in = new FileInputStream(file1);
                 FileOutputStream out = new FileOutputStream(file2)) {
                byte[] buffer = new byte[in.available()];
                int n = in.read(buffer);
                String str = new String(buffer, "UTF-8");
                buffer = str.getBytes("Windows-1251");
                out.write(buffer);
            }
        }
    }
}
