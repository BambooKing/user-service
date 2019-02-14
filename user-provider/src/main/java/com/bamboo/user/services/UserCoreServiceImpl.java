package com.bamboo.user.services;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.bamboo.user.IUserCoreService;
import com.bamboo.user.constants.ResponseCodeEnum;
import com.bamboo.user.dal.entity.User;
import com.bamboo.user.dal.persistence.UserMapper;
import com.bamboo.user.dto.UserLoginRequest;
import com.bamboo.user.dto.UserLoginResponse;
import com.bamboo.user.exception.ExceptionUtil;
import com.bamboo.user.exception.ServiceException;
import com.bamboo.user.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangxc
 */
public class UserCoreServiceImpl implements IUserCoreService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    /**
     * 调用user-api 登录接口
     *
     * @param request
     * @return
     */
    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        logger.info("login request:" + request);
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        //1.登录前验证
        try {
            beforeValidate(request);
            User user = userMapper.getUserByUserName(request.getUserName());
            if (user == null || !user.getPassword().equals(request.getPassword())) {
                userLoginResponse.setCode(ResponseCodeEnum.USERORPASSWORD_ERRROR.getCode());
                userLoginResponse.setMsg(ResponseCodeEnum.USERORPASSWORD_ERRROR.getMsg());
                return userLoginResponse;
            }
            userLoginResponse.setUid(user.getId());
            userLoginResponse.setAvatar(user.getAvatar());
            userLoginResponse.setCode(ResponseCodeEnum.USERORPASSWORD_ERRROR.getCode());
            userLoginResponse.setMsg(ResponseCodeEnum.USERORPASSWORD_ERRROR.getMsg());

        } catch (Exception e) {
            logger.error("login occur exception :" + e);
            ServiceException serviceException = (ServiceException) ExceptionUtil.handlerException4biz(e);
            userLoginResponse.setCode(serviceException.getErrorCode());
            userLoginResponse.setMsg(serviceException.getErrorMessage());
        } finally {
            logger.info("login response:" + userLoginResponse);
        }
        return userLoginResponse;
    }

    private void beforeValidate(UserLoginRequest request) {
        if (request == null) {
            throw new ValidateException("请求对象为空");
        }
        if (StringUtils.isEmpty(request.getUserName())) {
            throw new ValidateException("用户名为空");
        }
        if (StringUtils.isEmpty(request.getPassword())) {
            throw new ValidateException("密码为空");
        }
    }


}
