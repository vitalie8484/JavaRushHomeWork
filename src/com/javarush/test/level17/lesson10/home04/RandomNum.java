package com.javarush.test.level17.lesson10.home04;

/**
 * Created by FINTEST on 8/19/2016.
 */
public class RandomNum {
    public static void main(String[] args) {
        double r = Math.random();
        double inm = r * 1000;
        double i = inm % 5;
        System.out.println(r);
        System.out.println(inm);
        System.out.println(i);
        System.out.println((int) i);
    }
}
