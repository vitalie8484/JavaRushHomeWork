package com.javarush.test.level21.lesson16.big01;

public class Horse {

    String name;
    double speed;
    double distance;

    public Horse() {
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += Math.random() * speed;
    }

    public void print() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= Math.round(distance); i++)
            out = out.append(".");
        out.append(name);
        System.out.println(out);
    }
}
