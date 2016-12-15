package ru.test.gramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.gramis.entity.Role;
import ru.test.gramis.entity.Users;
import ru.test.gramis.exeption.UserExistException;
import ru.test.gramis.form.UserRegForm;
import ru.test.gramis.repository.UserRepository;
import ru.test.gramis.security.PassEncode;
import ru.test.gramis.service.UserService;

import java.sql.SQLException;
import java.util.Collections;

/**
 * Created by GRamis on 12.12.2016.
 * Сервис для работы с пользователем
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * поиск пользователя по id
     * @param id
     * @return пользователя Users
     */
    @Override
    public Users findUserById(Long id) {
        return userRepository.findOne(id);
    }

    /**
     * поиск пользователя по имени
     * @param name
     * @return
     */
    @Override
    public Users loadUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    /**
     * сохранение пользователя
     * @param userForm
     * @return пользователя Users
     * @throws UserExistException выбрасывается если в хранилище существует пользователь с таким же именем
     */
    @Override
    public Users save(UserRegForm userForm) throws UserExistException {
        Users result = userRepository.findUserWithoutRegister(userForm.getName());
        if (result != null){
            throw new UserExistException(result.getName());
        }
        Users users = new Users();
        users.setName(userForm.getName());
        users.setPassword(userForm.getPassword());
        users.setRole(Collections.singletonList(Role.ROLE_USER));
        users.setPassword(new PassEncode().encode(users.getPassword()));
        return userRepository.save(users);
    }
}
