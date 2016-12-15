package ru.test.gramis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import ru.test.gramis.entity.Users;
import ru.test.gramis.security.UserDetailsImpl;
import ru.test.gramis.service.UserService;

/**
 * Created by GRamis on 13.12.2016.
 */
@Component
public class UserUtil {

    @Autowired
    private UserService userService;

    /**
     * получение авторизованного пользователя
     * @return
     */
    public Users getCurrentUser() {
        UserDetailsImpl userContext = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = null;
        if (userContext != null && userContext.getUserInfo() != null)
            users = userService.findUserById(userContext.getUserInfo().getId());
        return users;
    }

    /**
     * проверка авторизован ли пользователь или нет
     * @return
     */
    public boolean isAuthorised() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (principal instanceof UserDetails) &&
                !((UserDetails) principal).getAuthorities().isEmpty();
    }

    /**
     * авторизует пользователя после сохранения в бд
     * @param authUser
     */
    public void setAuthUser(Users authUser){
        UserDetails userDetails = new UserDetailsImpl(authUser);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
