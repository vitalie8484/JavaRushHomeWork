package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen {

    public int getCountOfEggsPerMonth() {
        return 23;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.RUSSIA, getCountOfEggsPerMonth());
    }
}
