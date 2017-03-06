package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File myfile = File.createTempFile("myFile", null);

        InputStream in = new FileInputStream(myfile);
        OutputStream out = new FileOutputStream(myfile);

        Solution savedObject = new Solution(10);

        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(savedObject);

        out.close();
        objOut.close();

        Solution loadedSolution = new Solution(-4);
        ObjectInputStream objIn = new ObjectInputStream(in);
        Object loadedObject = objIn.readObject();

        loadedSolution = (Solution) loadedObject;

        if (savedObject.string.equals(loadedSolution.string))
            System.out.println(true);
        else
            System.out.println(false);

        System.out.println(savedObject.string);
        System.out.println(loadedSolution.string);

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE  hh:mm.ss";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}