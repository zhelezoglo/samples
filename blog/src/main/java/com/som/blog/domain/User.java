package com.som.blog.domain;

import com.som.blog.domain.base.UserRole;
import com.som.blog.domain.base.DomainObject;

import javax.persistence.Entity;

/**
 * @author zhelezoglo
 */
@Entity
public class User extends DomainObject {

    private String login;

    private String password;

    private String email;

    private UserRole role;

    public User(String login, String password, String email, UserRole role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
