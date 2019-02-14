package com.bamboo.user;

import com.bamboo.user.dto.UserLoginRequest;
import com.bamboo.user.dto.UserLoginResponse;

/**
 * @author wangxc
 */
public interface IUserCoreService {

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);
}
