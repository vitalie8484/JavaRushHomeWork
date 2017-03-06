package com.javarush.test.level16.lesson13.bonus03;

/**
 * Created by fintest on 8/18/2016.
 */
public class MyApp {
    static int count = 0;

    public class MyWorker extends Thread {
        public void run() {
            while (true) {
                try {
                    // Do this work every second forever unless interuppted
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        private void doWork() {
            // Simulate work that sometimes results in NullPointerException
            StringBuffer sb = new StringBuffer("My Work counter: ");
            if (count++ >= 5) {
                sb = null; //oops!
                count = 0;
            }
            sb.append(count);
            System.out.println(sb.toString());
        }
    }

    public MyApp() {
        MyWorker worker = new MyWorker();
        worker.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t.getName() + ": " + e);
                        MyWorker worker = new MyWorker();
                        worker.start();
                    }
                });
        worker.start();
    }

    public static void main(String[] args) {
        MyApp te = new MyApp();
    }
}
