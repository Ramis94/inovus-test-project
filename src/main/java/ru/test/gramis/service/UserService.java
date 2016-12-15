package ru.test.gramis.service;

import ru.test.gramis.entity.Users;
import ru.test.gramis.exeption.UserExistException;
import ru.test.gramis.form.UserRegForm;

import java.sql.SQLException;

/**
 * Created by GRamis on 12.12.2016.
 * Сервис для работы с пользователем
 */
public interface UserService {

    Users findUserById(Long id);

    Users loadUserByName(String name);

    Users save(UserRegForm userForm) throws UserExistException;
}
