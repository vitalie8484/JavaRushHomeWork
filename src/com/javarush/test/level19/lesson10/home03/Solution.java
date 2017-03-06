package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {

        Reader read = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(read);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] val = line.split(" ");
            int year = Integer.parseInt(val[val.length - 1]);
            int month = Integer.parseInt(val[val.length - 2]);
            int day = Integer.parseInt(val[val.length - 3]);

            String name = "";
            for (int i = 0; i < (val.length - 3); i++)
                name += val[i] + " ";

            PEOPLE.add(new Person(name.trim(), dateFormat.parse(day + "/" + month + "/" + year)));
        }

        read.close();
        reader.close();

        for (Person person : PEOPLE)
            System.out.println(person.getName() + " " + person.getBirthday());
    }

}
