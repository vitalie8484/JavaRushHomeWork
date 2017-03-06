package com.javarush.test.level16.lesson10.task04;

/* А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread tt = new TestThread();
        Thread t = new Thread(tt);
        t.start();
        Thread.sleep(20000);
        tt.i = 10000;
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //TestThread.isCancel = true;
        //TestThread.i = 10000;
    }

    public static class TestThread implements Runnable {
        public static boolean isCancel = false;
        public int i = 0;
        public void run() {
            while(i <= 9000) {
                try {
                    System.out.println("he-he" + i++);
                    isCancel = false;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
