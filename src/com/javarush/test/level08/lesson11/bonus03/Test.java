package com.javarush.test.level08.lesson11.bonus03;

public class Test {
    public static void main(String args[]) {
        String a = "a";
        String b = "a";
        String c = "c";

        int result = a.compareTo( b );
        System.out.println(result);

        result = b.compareTo( c );
        System.out.println(result);

        result = c.compareTo( a );
        System.out.println(result);
    }
}
