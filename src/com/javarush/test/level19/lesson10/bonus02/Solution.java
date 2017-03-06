package com.javarush.test.level19.lesson10.bonus02;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by FINTEST on 9/2/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Writer out = new FileConsoleWriter("d:\\fileWriter.txt");
        out.write("Eu merg acus acasa!");
        out.write(System.lineSeparator());
        out.write("Ha ha ha!!!!!!");

        out.close();
    }
}
