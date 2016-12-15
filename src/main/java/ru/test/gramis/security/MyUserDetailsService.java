package ru.test.gramis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.test.gramis.entity.Users;
import ru.test.gramis.service.UserService;

import java.sql.SQLException;

/**
 * Created by GRamis on 12.12.2016.
 * Этот сервис нуңен для authentication-provider в spring-security
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users userInfo = null;
        userInfo = userService.loadUserByName(s);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + s + " not found");
        return new UserDetailsImpl(userInfo);
    }
}
