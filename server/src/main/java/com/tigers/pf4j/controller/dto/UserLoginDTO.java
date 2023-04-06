package com.tigers.pf4j.controller.dto;

/**
 * {@code UserLoginDTO}
 *
 * @author Tigers Leung
 * @version 1.0
 * @since 1.0
 */
public class UserLoginDTO {

    private String username ;

    private String password ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
