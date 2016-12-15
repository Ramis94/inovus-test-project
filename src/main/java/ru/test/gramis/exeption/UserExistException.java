package ru.test.gramis.exeption;

import java.io.PrintStream;

/**
 * Created by GRamis on 13.12.2016.
 * Исключение выпадает когда в БД существует пользователь
 */
public class UserExistException extends Exception {

    public UserExistException(String name) {
        System.out.println("Пользователь с именем " + name + "существует");
    }
}
