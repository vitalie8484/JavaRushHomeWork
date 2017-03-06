package com.javarush.test.level26.lesson10.home01;

import com.javarush.test.level20.lesson02.task05.*;
import com.javarush.test.level20.lesson02.task05.Solution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vitalie on 2/12/2017.
 */
public class Consumer implements Runnable {
    protected BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int o;
                o = queue.take();
                System.out.println(o);
            }
        } catch (Exception ex) {
            System.out.println(String.format("[%s] thread was terminated (Consumer)", Thread.currentThread().getName()));
        }
    }
}
