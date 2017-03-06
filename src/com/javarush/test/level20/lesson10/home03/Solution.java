package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("myTemp", null);

        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(file);

        Solution.B b = new Solution().new B("B");

        ObjectOutputStream outObj = new ObjectOutputStream(out);
        outObj.writeObject(b);

        System.out.println(b.name);

        out.close();
        outObj.close();

        Solution.B b2;
        ObjectInputStream inObj = new ObjectInputStream(in);
        b2 = (Solution.B) inObj.readObject();

        System.out.println(b2.name);

        in.close();
        inObj.close();
    }

    public static class A {
        protected String name = "A";

        public A() {}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(super.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.name = (String) in.readObject();
        }

    }
}
