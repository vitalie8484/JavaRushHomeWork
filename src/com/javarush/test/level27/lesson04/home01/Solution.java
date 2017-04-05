package com.javarush.test.level27.lesson04.home01;

/* Модификаторы и дедлоки
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
*/
public class Solution {
    public Solution() {
        Object obj = getData();
    }

    public static void main(String[] args) {
        new Thread(Solution::new).start();
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Solution().getData();
    }

    public synchronized Object getData() {
        return new ThreadDeadlock().getData();
    }
}
