package com.bamboo.user.dto;

import com.bamboo.user.abs.AbstractResponse;

/**
 * @author wangxc
 */
public class UserLoginResponse extends AbstractResponse {
    private static final long serialVersionUID = 2101467921317684810L;

    private Integer uid;
    private String avatar;
    private String code;
    private String msg;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
