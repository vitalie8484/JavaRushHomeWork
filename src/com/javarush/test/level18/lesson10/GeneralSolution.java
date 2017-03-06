package com.javarush.test.level18.lesson10;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class GeneralSolution {
    public static void main(String[] args) {
        int idv = Integer.parseInt(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Reader in = null;

        try {
            String f1 = reader.readLine();
            in = new FileReader(f1);
            reader = new BufferedReader(in);

            String str = reader.readLine();

            String[] arr = str.split("\\s+");
            int id = 0;
            String productName = "";
            double price = 0;
            int quantity = 0;
            boolean found = false;

            int pas = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((pas % 4) == 0) {
                    id = Integer.parseInt(arr[i]);
                    if (id == idv)
                        found = true;
                    pas++;
                    continue;
                }

                if (((pas - 1) % 4) == 0) {
                    try {
                        price = Double.parseDouble(arr[i]);
                        pas += 2;
                        continue;
                    } catch (Exception e) {
                        productName = productName + arr[i] + " ";
                        continue;
                    }
                }

                if (((pas - 3) % 4) == 0) {
                    quantity = Integer.parseInt(arr[i]);
                    pas++;
                    if (found)
                        break;
                    else {
                        id = 0;
                        productName = "";
                        price = 0;
                        quantity = 0;
                    }
                }
            }

            System.out.println(id + " " + productName.trim() + " " + price + " " + quantity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
