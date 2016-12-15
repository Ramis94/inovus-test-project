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

/**
 * Created by GRamis on 12.12.2016.
 *
 * Контроллер для входа в систему
 */
@Controller
public class SignInController {

    @Autowired
    UserUtil userUtil;

    @Autowired
    HttpServletRequest request;

    private static Logger logger = LoggerFactory.getLogger(SignInController.class);

    /**
     * метод для получения страницы sign-in.jsp(авторизация) если пользователь не зарегистрирован в системе
     * если зарегистрирован то перенаправляет на страницу welcome
     * @return
     */
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView getSignIn(){
        ModelAndView modelAndView = new ModelAndView("sign-in");
        try{
            logger.info("get sign in page");
            if(userUtil.isAuthorised()){
                logger.info("redirect to /welcome");
                return new ModelAndView("redirect:/welcome");
            }
            for (Cookie cookie : request.getCookies()) {
                if ("userName".equals(cookie.getName())){
                    modelAndView.addObject("userName", cookie.getValue());
                }
            }
        } catch (Throwable t){
            logger.error(t.getMessage());
            modelAndView.addObject("error", "Произошла не предвиденная ошибка");
        }
        return modelAndView;
    }
}
