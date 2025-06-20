package com.zkg.userBackend;

import com.zkg.userBackend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class UserBackendApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    void registUser() {
        String userAccount = "苏明雨aa";
        String userPassword = "s12345678";
        String checkPassword = "s12345678";
        boolean rs = userService.registUser(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(rs);
/*         userAccount = "zhukaige";
        userPassword = "12345678";
        checkPassword = "1234567";
        rs = userService.registUser(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, rs);
        userAccount = "zhukaige_^";
        checkPassword = "12345678";
        rs = userService.registUser(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, rs);
       userAccount = "zhukaige";
        rs = userService.registUser(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(rs > 0 );*/
    }

}
