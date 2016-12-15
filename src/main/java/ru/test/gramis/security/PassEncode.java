package ru.test.gramis.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by GRamis on 12.12.2016.
 */
public class PassEncode implements PasswordEncoder {

    PasswordEncoder passwordEncoder = new StandardPasswordEncoder("3A$&j"); // use SHA-256, 3A$&j - salt

    @Override
    public String encode(CharSequence charSequence) {
        return passwordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return passwordEncoder.matches(charSequence, s);
    }
}
