package com.dreamTimes.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/mybatis-spring.xml")
public class GoodsDaoTest {
    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void sumCount() {
        int i = goodsDao.sumCount();
        System.out.println(i);
    }
}