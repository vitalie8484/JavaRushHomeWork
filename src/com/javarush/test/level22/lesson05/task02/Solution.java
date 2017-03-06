package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();

        char[] chars = string.toCharArray();

        int countTab = 0;
        int start = 0, end = 0;
        boolean change = false;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\t') {
                countTab++;
                change = true;
            }
            if (countTab == 1 && change) {
                start = i;
                change = false;
            }
            else if (countTab == 2 && change) {
                end = i;
                break;
            }
        }

        if (end == 0)
            throw new TooShortStringException();

        return string.substring(start + 1, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        //System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        //System.out.println(getPartOfString("\t\t"));                    //
        //System.out.println(getPartOfString("123\t123"));                //Exception
        //System.out.println(getPartOfString(null));                      //Exception
    }
}
