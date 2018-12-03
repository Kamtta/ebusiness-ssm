package com.dreamTimes.controller;

import com.dreamTimes.beans.Page;
import com.dreamTimes.beans.User;
import com.dreamTimes.dao.UserDao;
import com.dreamTimes.dto.Userdto;
import com.dreamTimes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserServiceController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String telephone,String password,HttpServletRequest request){
        return userService.loginService(telephone,password,request);
    }

    @RequestMapping("welcomeuser")
    public String welcome(){
        return "welcomeuser";
    }

    @RequestMapping("welcome")
    public String welcomejsp(){
        return "welcome";
    }

    @RequestMapping("user")
    public String user(){
        return "user";
    }

    @RequestMapping(value = "usermanage",method = RequestMethod.GET)
    @ResponseBody
    public Page usermanage(Integer n){
        Page page = userService.userManage(n);
        return page;
    }

    @RequestMapping("update")
    public String update(){
        return "update";
    }

    @RequestMapping("updateuser")
    public String updateUser(Userdto user){
        userDao.updateAdmin(user);
        User u = userDao.selectByname(user.getUname());
        if(u.getRlevel() == 1){
            return "welcomeuser";
        }
        return "user";
    }

    @RequestMapping(value = "selectuser",method = RequestMethod.GET)
    @ResponseBody
    public User select(String uname){
        User user = userDao.selectByUname(uname,1);
        return user;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(Userdto user){
        return userService.registerJudge(user);
    }

    @RequestMapping(value = "searchuserresult",method = RequestMethod.GET)
    @ResponseBody
    public List<User> search(String uname){
        List<User> list = userDao.selectByName(uname);
        return list;
    }

    @RequestMapping("deleteuser")
    public String deleteUser(String uname){
        int i = userDao.deleteAdmin(uname);
        if(i == 1){
            return "user";
        }
        return "searchuserview";
    }

    @RequestMapping("searchuserview")
    public String seachuser(){
        return "searchuser";
    }

    @RequestMapping("registerview")
    public String register(){
        return "register";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userManager");
        return "index";
    }

    @RequestMapping("forbidenuser")
    public String forbidenuser(){
        return "forbidenuser";
    }

    @GetMapping("showforbidenuser")
    @ResponseBody
    public Page showforbidenuser(Integer n){
        return userService.userforbiden(n);
    }

    @RequestMapping("unforbidenuser")
    public String unforbiden(Integer uid){
        userDao.unforbidenuser(uid);
        return "forbidenuser";
    }
}
