package com.javarush.test.level15.lesson12.home04;

public class Sun implements Planet {
    private static Sun instance;

    synchronized public static Sun getInstance() {
        if (instance == null)
            instance = new Sun();
        return instance;
    }

    private Sun() {
        System.out.println("Sun");
    }
}
