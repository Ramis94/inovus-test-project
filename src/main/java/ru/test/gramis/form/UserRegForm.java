package ru.test.gramis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by GRamis on 12.12.2016.
 * Форма проверки данных при регистрации нового пользователя
 */
public class UserRegForm {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9-_\\.]{4,}$", message = "Имя пользователя должно быть длиннее 4 символов и состоять из " +
            "цифр и букв английского алфавита")
    private String name;

    @NotEmpty
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})", message = "Пароль недостаточно сложен: должны быть цифры," +
            " заглавные и строчные буквы и длина минимум 8 символов")
    private String password;

    @NotEmpty
    private String confirmPassword;

    @AssertTrue(message = "Пароль и повтор пароля не совпадают")
    public boolean isValid(){
        return this.password == null || this.password.equals(this.confirmPassword);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
