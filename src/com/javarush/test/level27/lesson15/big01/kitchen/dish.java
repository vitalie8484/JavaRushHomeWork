package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        String rez = "";
        for (int i = 0; i < Dish.values().length; i++) {
            rez += Dish.values()[i] + ", ";
        }
        return rez.substring(0, rez.length() - 2);
    }
}
