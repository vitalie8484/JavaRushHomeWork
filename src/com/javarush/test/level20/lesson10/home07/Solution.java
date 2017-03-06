package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 1.
        Solution solution = new Solution("d:\\file1.dat");

        // 2.
        solution.writeObject("Acesta este textul meu nr.1");

        // 3.
        String file = "d:\\file2.dat";
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
        objOut.writeObject(solution);
        objOut.close();

        // 4.
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
        Solution solutionBack = (Solution) objIn.readObject();

        // 5.
        solutionBack.writeObject("Acesta este textul meu nr.2");

        // 6.
        solutionBack.stream.close();
        InputStream inputStream = new FileInputStream(solutionBack.fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    transient private FileOutputStream stream;
    String fileName;

    public Solution() {}

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
