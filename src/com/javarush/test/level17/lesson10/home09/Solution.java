package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileReader f1 = new FileReader(file1);
        FileReader f2 = new FileReader(file2);

        String str;

        reader = new BufferedReader(f1);
        while ((str = reader.readLine()) != null)
            allLines.add(str);

        reader = new BufferedReader(f2);
        while ((str = reader.readLine()) != null)
            forRemoveLines.add(str);

        f1.close();
        f2.close();
        reader.close();

        Solution sol = new Solution();
        try {
            sol.joinData();
        } catch (CorruptedDataException ex) {
            ex.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        boolean b3 = true;

        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                b3 = false;
                break;
            }
        }

        if (b3) {
            for (String s : forRemoveLines)
                allLines.remove(s);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
