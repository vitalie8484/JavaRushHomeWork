package com.javarush.test.level15.lesson12.home04;

public class Earth implements Planet {
    private static Earth instance;

    synchronized public static Earth getInstance() {
        if (instance == null)
            instance = new Earth();
        return instance;
    }

    private Earth() {
        System.out.println("Earth");
    }
}
