package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vital on 3/5/2017.
 */
public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                i++;
                map.put(String.valueOf(i), String.format("Some text for %s", i));
                //System.out.println(String.format("Some text for [%s]", i));
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println(String.format("%s thread was terminated", Thread.currentThread().getName()));
        }
    }
}
