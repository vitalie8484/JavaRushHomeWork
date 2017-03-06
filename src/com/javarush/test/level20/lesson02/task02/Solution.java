package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* ?????? ? ????? ? ????: JavaRush
?????????? ?????? ?????? ? ???? ? ?????? ?? ????? ??? ?????? JavaRush
? ????? your_file_name.tmp ????? ???? ????????? ???????? JavaRush
????? main ?????????? ?????? ??? ??? ? ?? ????????? ? ????????????
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //?? ?????? ????? your_file_name.tmp ? ????? TMP ??? ????????? outputStream/inputStream ? ???????????? ? ????? ? ?????? ????????? ?????
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - ??????????????? ???? users ??? ??????? javaRush ???
            User user = new User();
            user.setFirstName("Vitalie");
            user.setLastName("jurjiu");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            javaRush.users.add(user);
            javaRush.users.add(null);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - ????????? ???, ??? javaRush ? loadedObject ?????
            if (javaRush.equals(loadedObject))
                System.out.println(true);
            else
                System.out.println(false);

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - ?????????? ???? ?????
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users != null) {
                writer.println("yes");
                int n = users.size();
                writer.println(String.valueOf(n));
                for (User user : users) {
                    if (user == null)
                        writer.println("null");
                    else {
                        writer.println(user.getFirstName());
                        writer.println(user.getLastName());
                        writer.println(user.getBirthDate().getTime());
                        writer.println(user.isMale());
                        writer.println(user.getCountry().getDisplayedName());
                    }
                }
            } else
                writer.println("no");
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - ?????????? ???? ?????
            users.clear();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String notEmpty = reader.readLine();
            if ("yes".equals(notEmpty)) {
                int n = Integer.parseInt(reader.readLine());
                for (int i = 0; i < n; i++) {
                    User user;
                    String verify = reader.readLine();
                    if ("null".equals(verify)) {
                        user = null;
                        users.add(user);
                    } else {
                        user = new User();
                        user.setFirstName(verify);
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String country = reader.readLine();
                        switch (country) {
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default:
                                user.setCountry(User.Country.OTHER);
                        }
                        this.users.add(user);
                    }
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            if (javaRush.users.size() > 0) {
                for (int i = 0; i < javaRush.users.size(); i++) {
                    if ((javaRush.users.get(i) == null) && (this.users.get(i) == null))
                        continue;
                    if (!javaRush.users.get(i).getFirstName().equals(this.users.get(i).getFirstName()))
                        return false;
                    if (!javaRush.users.get(i).getLastName().equals(this.users.get(i).getLastName()))
                        return false;
                    if (javaRush.users.get(i).getBirthDate().compareTo(this.users.get(i).getBirthDate()) != 0)
                        return false;
                    if (javaRush.users.get(i).isMale() != this.users.get(i).isMale())
                        return false;
                    if (!javaRush.users.get(i).getCountry().getDisplayedName().equals(this.users.get(i).getCountry().getDisplayedName()))
                        return false;
                }
            } else
                return false;

            return true;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
