package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = new File("d:\\human.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name, true);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human vitalie = new Human("Vitalie", new Asset("nissan"));
            vitalie.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

            Human somePerson2 = new Human();
            somePerson2.load(inputStream);
            System.out.println(vitalie.equals(somePerson2));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            OutputStreamWriter write = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(write);
            String hasName = name != null ? "Yes" : "No";
            writer.append(hasName);
            writer.append(System.lineSeparator());
            writer.append(name);
            writer.append(System.lineSeparator());
            writer.append(String.valueOf(assets.size()));
            writer.append(System.lineSeparator());
            for (Asset asset : assets) {
                writer.append(asset.getName());
                writer.append(System.lineSeparator());
                writer.append(String.valueOf(asset.getPrice()));
                writer.append(System.lineSeparator());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            if ("Yes".equals(hasName)) {
                String str = reader.readLine();
                if (str != null)
                    name = str;
                try {
                    int n = Integer.parseInt(reader.readLine());
                    if (n > 0)
                        for (int i = 0; i < n; i++) {
                            Asset asset = new Asset(reader.readLine());
                            asset.setPrice(Double.parseDouble(reader.readLine()));
                            assets.add(asset);
                        }

                } catch (Exception ex) {
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (assets.size() != human.assets.size())
                return false;
            for (int i = 0; i < assets.size(); i++) {
                if (!assets.get(i).getName().equals(human.assets.get(i).getName()))
                    return false;
                if (assets.get(i).getPrice() != human.assets.get(i).getPrice())
                    return false;
            }
            return true;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }
    }
}
