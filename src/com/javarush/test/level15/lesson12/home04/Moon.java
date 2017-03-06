package com.javarush.test.level15.lesson12.home04;

public class Moon implements Planet {

    private static Moon instance;

    synchronized public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }

    private Moon() {
        System.out.println("Moon");
    }

}
