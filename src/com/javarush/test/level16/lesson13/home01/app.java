package com.javarush.test.level16.lesson13.home01;

public class app {
    public static void main(String[] args) throws InterruptedException {
        ProcesIntern pi = new ProcesIntern();
        pi.start();
        Thread.sleep(5000);
        pi.interrupt();
    }

    public static class ProcesIntern extends Thread {
        Thread thisProges = Thread.currentThread();

        public void run() {
            try {
                while (!thisProges.isInterrupted()) {
                    System.out.println("procesul meu");

                    Thread.sleep(500);

                }
            } catch (InterruptedException ex) {

            }
        }
    }
}
