package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
        if (args.length < 2 || args.length > 6 || args.length == 3)
            return;

        String var = null;
        try {
            var = args[0];
        } catch (Exception e) {
            System.out.print("No arguments!!!");
            System.exit(0);
        }

        switch (var) {
            case "-c":
                System.out.println(create(args[1], args[2], args[3]));
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                select(args[1]);
                break;
            default:
                System.out.print("Unrecognized command!!");
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
            System.out.print("Incorrect arguments!");
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
            System.out.print("Incorrect arguments!");
        }
    }

    private static void delete(String arg1) {
        try {
            id = Integer.parseInt(arg1);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
        } catch (Exception e) {
            System.out.print("Incorrect arguments!");
        }
    }

    private static void select(String arg1) {
        try {
            id = Integer.parseInt(arg1);
            Person p = allPeople.get(id);
            System.out.print(p.getName() + " " + (p.getSex().equals(Sex.FEMALE) ? "ж" : "м") + " " + sdfOut.format(p.getBirthDay()));
        } catch (Exception e) {
            System.out.print("Incorrect arguments!");
        }
    }
}
