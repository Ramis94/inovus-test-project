package ru.test.gramis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by GRamis on 12.12.2016.
 * Enum-ролей
 */
public enum  Role {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_ANONYMOUS("ROLE_ANONYMOUS");

    private String role;

    private Role(final String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
