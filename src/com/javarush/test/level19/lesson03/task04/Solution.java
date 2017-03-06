package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String firstName;
            String middleName;
            String lastName;
            Date birthDate = new Date();

            String rez =scanner.nextLine();

            String[] val = rez.split(" ");
            lastName = val[0];
            firstName = val[1];
            middleName = val[2];
            int day = Integer.parseInt(val[3]);
            int month = Integer.parseInt(val[4]) - 1;
            int year = Integer.parseInt(val[5]);
            Calendar calendar = new GregorianCalendar(year, month, day);

            Person person = new Person(firstName, middleName, lastName, calendar.getTime());

            return person;
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
