package com.javarush.test.level17.lesson10.bonus02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    private static int id;
    private static String name;
    private static Sex sex;
    private static Date birthDay;
    private static SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        String var = null;
        try {
            var = args[0];
        } catch (Exception e) {
            System.out.println("No arguments!!!");
            System.exit(0);
        }

        switch (var) {
            case "-c":
                if (((args.length - 1) % 3) == 0) {
                    for (int i = 1; i <= args.length - 1; i += 3) {
                        String s1 = args[i];
                        String s2 = args[i + 1];
                        String s3 = args[i + 2];
                        System.out.println(create(s1, s2, s3));
                    }
                } else
                    return;
                break;
            case "-u":
                if (((args.length - 1) % 4) == 0) {
                    for (int i = 1; i <= args.length - 1; i += 4) {
                        String s1 = args[i];
                        String s2 = args[i + 1];
                        String s3 = args[i + 2];
                        String s4 = args[i + 3];
                        update(s1, s2, s3, s4);
                    }
                } else
                    return;
                break;
            case "-d":
                for (int i = 1; i < args.length; i++)
                    delete(args[i]);
                break;
            case "-i":
                for (int i = 1; i < args.length; i++)
                    select(args[i]);
                break;
            default:
                System.out.println("Unrecognized command!!");
        }
    }

    private static int create(String arg1, String arg2, String arg3) {
        try {
            name = arg1;
            if (arg2.equals("м"))
                sex = Sex.MALE;
            else if (arg2.equals("ж"))
                sex = Sex.FEMALE;
            else
                throw new Exception();
            birthDay = sdfIn.parse(arg3);

            if (sex.equals(Sex.MALE))
                allPeople.add(Person.createMale(name, birthDay));
            else
                allPeople.add(Person.createFemale(name, birthDay));
        } catch (Exception e) {
            System.out.println("Incorrect arguments!");
        }
        return allPeople.size() - 1;
    }

    private static void update(String arg1, String arg2, String arg3, String arg4) {
        try {
            id = Integer.parseInt(arg1);
            name = arg2;
            if (arg3.equals("м"))
                sex = Sex.MALE;
            else if (arg3.equals("ж"))
                sex = Sex.FEMALE;
            else
                throw new Exception();
            birthDay = sdfIn.parse(arg4);

            if (sex.equals(Sex.MALE))
                allPeople.set(id, Person.createMale(name, birthDay));
            else
                allPeople.set(id, Person.createFemale(name, birthDay));
        } catch (Exception e) {
            System.out.println("Incorrect arguments!");
        }
    }

    private static void delete(String arg1) {
        try {
            id = Integer.parseInt(arg1);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
        } catch (Exception e) {
            System.out.println("Incorrect arguments!");
        }
    }

    private static void select(String arg1) {
        try {
            id = Integer.parseInt(arg1);
            Person p = allPeople.get(id);
            System.out.println(p.getName() + " " + (p.getSex().equals(Sex.FEMALE) ? "ж" : "м") + " " + sdfOut.format(p.getBirthDay()));
        } catch (Exception e) {
            System.out.println("Incorrect arguments!");
        }
    }
}

