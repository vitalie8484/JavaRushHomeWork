package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int id = 0;
        String param = args[0];
        String productName = "";

        if (!param.equals("-c"))
            System.exit(0);

        for (int i = 1; i < (args.length - 2); i++)
            productName += args[i] + " ";

        double price = Double.parseDouble(args[args.length - 2]);
        int quantity = Integer.parseInt(args[args.length - 1]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String line = null;

        FileReader read = new FileReader(fileName);
        reader = new BufferedReader(read);
        while ((line = reader.readLine()) != null) {
            System.out.println(line.length());
            if (line.length() > 1)
                if (Integer.parseInt(line.substring(0, 8).trim()) >= id)
                    id = Integer.parseInt(line.substring(0, 8).trim()) + 1;
        }
        reader.close();
        read.close();

        FileWriter write = new FileWriter(fileName, true);
        BufferedWriter writer = new BufferedWriter(write);

        if (id == 0) {
            id = 1;
            line = createLine(id, productName, price, quantity);

            writer.append(line);
        } else {
            line = createLine(id, productName, price, quantity);

            writer.write(System.lineSeparator());
            writer.append(line);
        }

        writer.close();
        write.close();
    }

    public static String createLine(int id, String productName, double price, int quantity) {
        String line = "";
        line = String.valueOf(id);
        if (line.length() < 8)
            line = fillSpaces(line, 8);
        else if (line.length() > 8)
            line = line.substring(0, 8);

        line = line + productName;
        if (line.length() < 38)
            line = fillSpaces(line, 38);
        else if (line.length() > 38)
            line = line.substring(0, 38);

        line = line + String.valueOf(price);
        if (line.length() < 46)
            line = fillSpaces(line, 46);
        else if (line.length() > 46)
            line = line.substring(0, 46);

        line = line + String.valueOf(quantity);
        if (line.length() < 50)
            line = fillSpaces(line, 50);
        else if (line.length() > 50)
            line = line.substring(0, 50);

        return line;
    }

    public static String fillSpaces(String s, int p) {
        StringBuilder rez = new StringBuilder(s);
        while (rez.length() < p)
            rez.append((char) 32);
        return rez.toString();
    }
}
