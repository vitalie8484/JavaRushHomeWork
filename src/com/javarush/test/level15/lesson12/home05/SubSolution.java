package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution {
    public SubSolution(int i) {
        super(i);
    }

    public SubSolution(int i, int ii) {
        super(i, ii);
    }

    public SubSolution(int i, int ii, int iii) {
        super(i, ii, iii);
    }

    SubSolution(String s) {
        super(s);
    }

    SubSolution(String s, String ss) {
        super(s, ss);
    }

    SubSolution(String s, String ss, String sss) {
        super(s, ss, sss);
    }

    protected SubSolution(float f) {
        super(f);
    }

    protected SubSolution(float f, float ff) {
        super(f, ff);
    }

    protected SubSolution(float f, float ff, float fff) {
        super(f, ff, fff);
    }

    private SubSolution(double d) {
        super((float) d);
    }

    private SubSolution(double d, double dd) {
        super((float) d, (float) dd);
    }

    private SubSolution(double d, double dd, double ddd) {
        super((float) d, (float) dd, (float) ddd);
    }
}
