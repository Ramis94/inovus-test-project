package ru.test.gramis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.test.gramis.util.UserUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by GRamis on 12.12.2016.
 * Контроллер приветствия пользователя
 */
@Controller
public class WelcomeController {

    @Autowired
    UserUtil userUtil;

    @Autowired
    private HttpServletResponse response;

    private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /**
     *
     * @return возвращает страницу welcome
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView getWelcomePage(){
        ModelAndView modelAndView = new ModelAndView("welcome");
        try{
            String userName = userUtil.getCurrentUser().getName();
            modelAndView.addObject("userName", userName);
            response.addCookie(new Cookie("userName" , userName));
        } catch (Throwable t) {
            logger.error(t.getMessage());
            modelAndView.addObject("error", "Произошла не предвиденная ошибка");
        }
        logger.info("get welcome page");
        return modelAndView;
    }
}
