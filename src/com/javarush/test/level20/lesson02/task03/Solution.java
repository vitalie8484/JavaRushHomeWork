package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        s.fillInPropertiesMap();
    }

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            InputStream file = new FileInputStream(fileName);

            load(file);
            file.close();

            OutputStream fileout = new FileOutputStream(fileName);
            save(fileout);
            fileout.close();

            for (Map.Entry<String, String> pair : properties.entrySet())
                System.out.println(pair.getKey() + " = " + pair.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        if (!properties.isEmpty() && properties.size() > 0) {

            //properties.putAll(properties);

            Properties pr = new Properties();
            for (Map.Entry<String, String> pair : properties.entrySet())
                pr.setProperty(pair.getKey(), pair.getValue());

            pr.store(outputStream, "Properties");
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.load(inputStream);

        if (!pr.isEmpty())
            for (Map.Entry<Object, Object> pair : pr.entrySet())
                properties.put(String.valueOf(pair.getKey()), String.valueOf(pair.getValue()));
    }
}
