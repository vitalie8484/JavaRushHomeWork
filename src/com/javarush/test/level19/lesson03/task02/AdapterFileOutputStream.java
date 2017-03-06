package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStreamIntern;

    public AdapterFileOutputStream(FileOutputStream fileOutputStreamIntern) {
        this.fileOutputStreamIntern = fileOutputStreamIntern;
    }

    public void flush() throws IOException {
        fileOutputStreamIntern.flush();
    }

    public void writeString(String s) throws IOException {
        fileOutputStreamIntern.write(s.getBytes());
    }

    public void close() throws IOException {
        fileOutputStreamIntern.close();
    }
}

