package ru.test.gramis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.test.gramis.entity.Users;
import ru.test.gramis.exeption.UserExistException;
import ru.test.gramis.form.UserRegForm;
import ru.test.gramis.service.UserService;
import ru.test.gramis.util.UserUtil;

import javax.validation.Valid;
import java.sql.SQLException;

/**
 * Created by GRamis on 12.12.2016.
 * Регистрация пользователя
 */
@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserUtil userUtil;

    private static Logger logger = LoggerFactory.getLogger(SignUpController.class);

    /**
     *
     * @return получает страницу sign-up.jsp(регистрация) если не авторизован
     * если авторизован то перенаправляет на страницу welcome
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView getSignUp(){
        ModelAndView modelAndView = new ModelAndView("sign-up");
        try {
            if (userUtil.isAuthorised()) {
                logger.info("user is auth, redirect to welcome");
                return new ModelAndView("redirect:/welcome");
            }
            logger.info("get sign up page");
        } catch (Throwable t) {
            logger.error(t.getMessage());
            modelAndView.addObject("error", "Произошла не предвиденная ошибка");
        }
        return modelAndView;
    }

    /**
     * отправка post-запроса с данными пользователя
     * @param userForm - обработка веденных данных
     * @param bindingResult - результат овработки данных
     * @return если успешно, то открывает страницу welcome
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView postSingUp(@Valid @ModelAttribute("sign-up")UserRegForm userForm, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                logger.error("error params in sign up");
                return new ModelAndView("sign-up");
            }
            try {
                logger.info("saving user" + userForm.getName());
                Users users = userService.save(userForm);
                logger.info("saved user" + userForm.getName());
                userUtil.setAuthUser(users);
                logger.info("user is auth" + users.getName());
            } catch (UserExistException e) {
                logger.error("error saving user: user is exist");
                ModelAndView modelAndView = new ModelAndView("sign-up");
                modelAndView.addObject("error", "Пользователь с таким именем уже зарегистрирован");
                return modelAndView;
            }
        } catch (Throwable t){
            logger.error(t.getMessage());
            return new ModelAndView("sign-up").addObject("error", "Произошла не предвиденная ошибка");
        }
        return new ModelAndView("redirect:/");
    }
}
