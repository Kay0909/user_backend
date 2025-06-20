package com.zkg.userBackend.service.impl;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkg.userBackend.model.domain.User;
import com.zkg.userBackend.service.UserService;
import com.zkg.userBackend.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2025-05-13 12:23:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Boolean registUser(String userAccount, String userPassword, String checkPassword) {
        // 1 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return false;
        }
        if (userAccount.length() < 4) {
            return false;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return false;
        }
        /*String str = ".*[^a-zA-Z0-9].*";
        if (userAccount.matches(str)) {
            return -1;
        }*/
        if (!StringUtils.equals(userPassword, checkPassword)) {
            return false;
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userAccount", userAccount);
        long queryRs = this.baseMapper.selectCount(wrapper);
        if (queryRs > 0) {
            return false;
        }
        // 2 密码加密
        String newPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes(StandardCharsets.UTF_8));
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(newPassword);
        boolean saveRs = this.save(user);
        if (!saveRs) {
            return false;
        }
        return true;
    }
}




