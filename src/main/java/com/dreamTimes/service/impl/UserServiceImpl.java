package com.dreamTimes.service.impl;

import com.dreamTimes.beans.Page;
import com.dreamTimes.beans.User;
import com.dreamTimes.dao.UserDao;
import com.dreamTimes.dto.Userdto;
import com.dreamTimes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String loginService(String telephone, String password, HttpServletRequest req) {
        User user = userDao.selectByname(telephone);
        if(user != null) {
            if(user.getUpwd().equals(password)){
                if(user.getRlevel() == 2){
                    req.setAttribute("uname",telephone);
                    HttpSession session = req.getSession();
                    session.setAttribute("userManager",user);
                    return "main";
                }
                if(user.getRlevel() == 1){
                    req.setAttribute("uname",telephone);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    return "usermain";
                }
            }else{
                return "index";
            }
        }
        return "index";
    }

    @Override
    public Page userManage(Integer pagen) {
        if(pagen == 0){
            pagen += 1;
        }
        Page page = new Page();
        page.setCount(userDao.sumCount(1));
        page.setCurrentPage(pagen);
        page.setContent(userDao.findContent(1,(pagen-1)*page.getPageCount(),page.getPageCount()));
        return page;
    }

    @Override
    public String registerJudge(Userdto userdto) {
        User user = userDao.selectByname(userdto.getUname());
        if(user == null){
            userDao.insertUser(userdto);
            return "index";
        }
        return "redirect:registerview";
    }

    @Override
    public Page userforbiden(Integer pagen) {
        if(pagen == 0){
            pagen = 1;
        }
        Page page = new Page();
        page.setCount(userDao.sumCountByIfdelete(1));
        page.setCurrentPage(pagen);
        page.setContent(userDao.findContentByIfdelete(1,(pagen-1)*page.getPageCount(),page.getPageCount()));
        return page;
    }
}
