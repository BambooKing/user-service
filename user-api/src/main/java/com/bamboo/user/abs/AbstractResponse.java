package com.bamboo.user.abs;

import java.io.Serializable;

/**
 * @author wangxc
 */
public class AbstractResponse implements Serializable {
    private String core;
    private String msg;

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
