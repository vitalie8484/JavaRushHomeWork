package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {

    private ArrayList<Horse> horses = new ArrayList<Horse>();
    private static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();

        Horse hores1 = new Horse("Horse_1", 3, 0);
        Horse hores2 = new Horse("Horse_2", 3, 0);
        Horse hores3 = new Horse("Horse_3", 3, 0);

        game.getHorses().add(hores1);
        game.getHorses().add(hores2);
        game.getHorses().add(hores3);

        game.run();

        game.printWinner();
    }

    public ArrayList<Horse>     getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses)
            horse.move();
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = new Horse("new", 0, 0);
        for (Horse horse : horses)
            if (horse.getDistance() >= winner.getDistance())
                winner = horse;
        return  winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
