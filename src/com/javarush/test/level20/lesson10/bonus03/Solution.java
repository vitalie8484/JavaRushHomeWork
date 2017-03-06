package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> result = detectAllWords(crossword, "home", "same");

        System.out.println(result);

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> result = new ArrayList<>();
        List<String> wrds = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
            wrds.add(words[i]);

        for (int x = 0; x < crossword.length; x++) {

            for (int y = 0; y < crossword[x].length; y++) {

                Iterator<String> iterator = wrds.iterator();

                while (iterator.hasNext()) {

                    String str = iterator.next();
                    Word rez = null;

                    if (str.startsWith(String.valueOf((char) crossword[x][y]))) {
                        rez = direction1(crossword, str, x, y);
                        if (rez == null)
                            rez = direction2(crossword, str, x, y);
                        if (rez == null)
                            rez = direction3(crossword, str, x, y);
                        if (rez == null)
                            rez = direction4(crossword, str, x, y);
                        if (rez == null)
                            rez = direction5(crossword, str, x, y);
                        if (rez == null)
                            rez = direction6(crossword, str, x, y);
                        if (rez == null)
                            rez = direction7(crossword, str, x, y);
                        if (rez == null)
                            rez = direction8(crossword, str, x, y);
                    }

                    if (rez != null) {
                        result.add(rez);
                        iterator.remove();
                    }
                }
            }
        }

        return result;
    }

    public static Word direction1(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int j = y; j < y + wrd.length; j++) {
                if (wrd[j - y] != (char) crossword[x][j])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y + wrd.length - 1, x);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction2(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x; i < x + wrd.length; i++) {
                if (wrd[i - x] != (char) crossword[i][y + i - x])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y + wrd.length - 1, x + wrd.length - 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction3(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x; i < x + wrd.length; i++) {
                if (wrd[i - x] != (char) crossword[i][y])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y, x + wrd.length - 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction4(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x + wrd.length - 1; i >= x ; i--) {
                if (wrd[i - x] != (char) crossword[i][y - i - x])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y - wrd.length + 1, x + wrd.length - 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction5(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int j = y - wrd.length + 1; j <= y; j++) {
                if (wrd[y - j] != (char) crossword[x][j])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y - wrd.length + 1, x);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction6(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x - wrd.length + 1; i <= x; i++) {
                if (wrd[x - i] != (char) crossword[i][y - x + i])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y - wrd.length + 1, x - wrd.length + 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction7(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x - wrd.length + 1; i <= x; i++) {
                if (wrd[x - i] != (char) crossword[i][y])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y, x - wrd.length + 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static Word direction8(int[][] crossword, String word, int x, int y) {
        char[] wrd = word.toCharArray();
        try {
            for (int i = x - wrd.length + 1; i <= x ; i++) {
                if (wrd[x - i] != (char) crossword[i][y - i + x])
                    throw new Exception();
            }
            Word rez = new Word(word);
            rez.setStartPoint(y, x);
            rez.setEndPoint(y + wrd.length - 1, x - wrd.length + 1);
            return  rez;
        } catch (Exception e) {
            return null;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
