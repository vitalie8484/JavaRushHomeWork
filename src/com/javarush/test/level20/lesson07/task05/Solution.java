package com.javarush.test.level20.lesson07.task05;

import java.io.*;
import java.util.Date;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public static void main(String[] args) throws InterruptedException {
        Solution s =  new Solution(100);
        Thread.sleep(3000);

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream("d:\\file.txt");
            out = new FileOutputStream("d:\\file.txt");

            System.out.println("Before serialization");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(s);

            out.close();
            objOut.close();

            s.runner.interrupt();

            Solution s2;
            ObjectInputStream objIn = new ObjectInputStream(in);
            s2 = (Solution) objIn.readObject();

            System.out.println("After serialization");

            in.close();
            objIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        try {
            while (!runner.isInterrupted()) {
                System.out.println(new Date() + ", speed = " + speed);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }
}
