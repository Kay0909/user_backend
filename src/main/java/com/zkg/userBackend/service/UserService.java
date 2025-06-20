package com.zkg.userBackend.service;

import com.zkg.userBackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-05-13 12:23:07
*/
public interface UserService extends IService<User> {
        Boolean registUser(String userAccount, String userPassword, String checkPassword);
}
