package com.zkg.userBackend.controller;


import com.zkg.userBackend.common.BaseResponse;
import com.zkg.userBackend.common.ErrorCode;
import com.zkg.userBackend.common.ResultUtils;
import com.zkg.userBackend.exceptions.BusinessException;
import com.zkg.userBackend.model.domain.UserRegisterRequest;
import com.zkg.userBackend.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;
    // region 登录相关

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<Boolean> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }
        Boolean result = userService.registUser(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }


}
