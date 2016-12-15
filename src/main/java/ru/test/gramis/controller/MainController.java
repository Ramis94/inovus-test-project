package ru.test.gramis.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.gramis.util.UserUtil;
import org.slf4j.Logger;

/**
 * Created by GRamis on 12.12.2016.
 * Контроллер главной страницы
 */
@Controller
public class MainController {

    @Autowired
    UserUtil userUtil;

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     *
     * @return перенаправляет на страницу приветствия
     */
    @RequestMapping(value = "/")
    public String getMainPage(){
        logger.info("get main page");
        return "redirect:/welcome";
    }
}
