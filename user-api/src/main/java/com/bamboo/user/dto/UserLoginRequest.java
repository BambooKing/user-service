package com.bamboo.user.dto;

import com.bamboo.user.abs.AbstractResponse;

/**
 * @author wangxc
 */
public class UserLoginRequest extends AbstractResponse {
    private static final long serialVersionUID = 1580928576999728140L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
