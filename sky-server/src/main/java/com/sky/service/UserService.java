package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * 功能描述
 *
 * @author lenovo
 * @date 2024/02/02  0:13
 */
public interface UserService {

    User wxLogin(UserLoginDTO userLoginDTO);
}
