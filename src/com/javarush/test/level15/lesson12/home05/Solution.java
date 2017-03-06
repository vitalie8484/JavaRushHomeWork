package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(int i) {}
    public Solution(int i, int ii) {}
    public Solution(int i, int ii, int iii) {}

    Solution(String s) {}
    Solution(String s, String ss) {}
    Solution(String s, String ss, String sss) {}

    protected Solution(float f) {}
    protected Solution(float f, float ff) {}
    protected Solution(float f, float ff, float fff) {}

    private Solution(double d) {}
    private Solution(double d, double dd) {}
    private Solution(double d, double dd, double ddd) {}

}

