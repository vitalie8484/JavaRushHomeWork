 package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String name;
    static Thread thr;

    @Override
    public void run() {
        try {
            while (!thr.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(name);
                Thread.sleep(90);
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.name = threadName;
        thr = new Thread(this);
        thr.start();
    }

    @Override
    public void stop() {
        thr.interrupt();
    }
}
