package com.zkg.userBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zkg.userBackend.mapper")
public class UserBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserBackendApplication.class, args);
    }

}
