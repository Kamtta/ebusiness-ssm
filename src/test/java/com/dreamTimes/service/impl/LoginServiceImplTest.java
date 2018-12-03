package com.dreamTimes.service.impl;

import com.dreamTimes.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/mybatis-spring.xml","classpath:spring/spring-service.xml"})
public class LoginServiceImplTest {
    @Autowired
    private LoginService loginService;
    @Test
    public void getLoginInfo() {
        loginService.getLoginInfo("15822869305",1);
    }
}