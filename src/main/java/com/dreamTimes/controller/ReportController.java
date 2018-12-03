package com.dreamTimes.controller;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping("report")
    public String report(){
        return "report";
    }

    @GetMapping("listshow")
    @ResponseBody
    public List<Goods> listshow(){
        List<Goods> list = goodsDao.getAll();
        return list;
    }
}
