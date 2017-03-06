package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        List<String> fileList1 = new ArrayList<>();
        List<String> fileList2 = new ArrayList<>();

        Reader read = new FileReader(fileName1);
        reader = new BufferedReader(read);
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            fileList1.add(line);
        }

        read = new FileReader(fileName2);
        reader = new BufferedReader(read);
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            fileList2.add(line);
        }

        for (int i = 0; i < fileList2.size(); i++) {
            if (fileList1.size() > i) {
                if (fileList2.get(i).equals(fileList1.get(i))) {
                    lines.add(new LineItem(Type.SAME, fileList2.get(i)));
                    continue;
                } else if (fileList2.get(i).equals(fileList1.get(i + 1)) && !fileList2.get(i + 1).equals(fileList1.get(i))) {
                    lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                    fileList1.remove(i);
                } else {
                    lines.add(new LineItem(Type.ADDED, fileList2.get(i)));
                    fileList1.add(i, fileList2.get(i));
                    continue;
                }

                if (fileList2.get(i).equals(fileList1.get(i)))
                    lines.add(new LineItem(Type.SAME, fileList2.get(i)));
            }
        }
        while (fileList1.size() > fileList2.size()) {
            lines.add(new LineItem(Type.REMOVED, fileList1.get(fileList2.size())));
            fileList1.remove(fileList2.size());
        }

        while (fileList1.size() < fileList2.size()) {
            lines.add(new LineItem(Type.ADDED, fileList2.get(fileList1.size())));
            fileList1.add(fileList1.size(), fileList2.get(fileList1.size()));
        }

        for (LineItem item : lines)
            System.out.println(item.type + " " + item.line);

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
