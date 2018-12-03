package com.dreamTimes.controller;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class ControllerTest {

    @Autowired
    private GoodsService goodsService;
//    注解为控制器可以提供哪些url请求
    @RequestMapping("springmvc")
    public String test(){
        return "springmvc-test";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("goodsManage")
    public String manage(Model model){
        List<Goods> list = goodsService.getall();
        model.addAttribute("goodslist",list);

        return "managegoods";
    }
}
