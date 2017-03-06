package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {

    private Thread tar;

    public LoggingStateThread(Thread t) {
        this.tar = t;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = tar.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != tar.getState()) {
                state = tar.getState();
                System.out.println(state);
            }
        }
    }
}
