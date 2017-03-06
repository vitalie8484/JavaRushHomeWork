package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants {
        public static final String STR_1 = "Server is not accessible for now.";
        public static final String STR_2 = "User is not authorized.";
        public static final String STR_3 = "User is banned.";
        public static final String STR_4 = "Access is denied.";
    }

    Constants CONS = new Constants();

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(CONS.STR_1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(CONS.STR_1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(CONS.STR_2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(CONS.STR_2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(CONS.STR_3);
        }

        public BannedUserException(Throwable cause) {
            super(CONS.STR_3, cause);
        }
    }

        public class RestrictionException extends Exception {
        public RestrictionException() {
            super(CONS.STR_4);
        }

        public RestrictionException(Throwable cause) {
            super(CONS.STR_4, cause);
        }
    }
}
