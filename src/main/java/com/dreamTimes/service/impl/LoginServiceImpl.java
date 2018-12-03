package com.dreamTimes.service.impl;

import com.dreamTimes.beans.User;
import com.dreamTimes.dao.UserDao;
import com.dreamTimes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;
    @Override
    public void getLoginInfo(String uname,Integer level) {
        User user = userDao.selectByUname(uname,level);
    }
}
