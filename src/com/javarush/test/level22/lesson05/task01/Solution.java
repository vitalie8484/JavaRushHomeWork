package com.javarush.test.level22.lesson05.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int firstSpaceIndex = string.indexOf(" ") + 1;
        char[] chars = string.toCharArray();
        int countSpace = 0;
        int lastSpaceIndex = 0; //
        for (int i = 0; i < string.length(); i++)
        {
            if (chars[i] == ' ')
            {
                countSpace++;
                if (countSpace == 4)
                {
                    lastSpaceIndex = string.length();
                } else if (countSpace == 5)
                {
                    lastSpaceIndex = i;
                    break;
                }
            }
        }
        if (countSpace < 4)
        {
            throw new TooShortStringException();
        }
        return string.substring(firstSpaceIndex, lastSpaceIndex);
    }

    public static class TooShortStringException extends Exception {
    }
}
