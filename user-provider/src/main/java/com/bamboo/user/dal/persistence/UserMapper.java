package com.bamboo.user.dal.persistence;

import com.bamboo.user.dal.entity.User;

/**
 * @author wangxc
 */
public interface UserMapper {
    /**
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

}
