package com.dreamTimes.service.impl;

import com.dreamTimes.service.DeleteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring/mybatis-spring.xml","classpath:spring/spring-service.xml"})
public class DeleteServiceImplTest {
    @Autowired
    private DeleteService deleteService;
    @Test
    public void deleteByTname() {
        String tname = "白菜";
        deleteService.deleteByTname(tname);
    }
}