package com.dreamTimes.controller;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.beans.Page;
import com.dreamTimes.dao.GoodsDao;
import com.dreamTimes.dto.Goodsdto;
import com.dreamTimes.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping(value = "goodsmanage",method = RequestMethod.GET)
    @ResponseBody
    public Page goodsManage(@RequestParam("n") Integer pagen){
        Page page = goodsService.goodsManage(pagen);
        return page;
    }

    @RequestMapping("managegoods")
    public String managegoods(){
        return "managegoods";
    }

    @RequestMapping("deletegoods")
    public String delete(Integer gid){
        goodsDao.deletegoods(gid);
        return "managegoods";
    }

    @RequestMapping("updategoods")
    public String updategoods(){
        return "updategoods";
    }

    @RequestMapping(value = "select",method = RequestMethod.GET)
    @ResponseBody
    public Goods select(Integer gid){
        Goods goods = goodsDao.select(gid);
        return goods;
    }

    @RequestMapping("goods")
    public String goods(){
        return "goods";
    }

    @RequestMapping("searchgoods")
    public String searchGoods(){
        return "searchgoods";
    }

    @RequestMapping("addgoods")
    public String addGoods(){
        return "addgoods";
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Goodsdto goods,HttpServletRequest req) throws IOException {
        String servletPath = req.getServletContext().getRealPath("/")+"onload\\";
        goodsService.addGoods(goods,servletPath);
        return "managegoods";
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public List<Goods> search(String gname){
        List<Goods> list = goodsDao.selectAll(gname);
        return list;
    }

    @RequestMapping("downgoods")
    public String downgoods(){
        return "downgoods";
    }

    @GetMapping("downgoodsshow")
    @ResponseBody
    public Page downgoodsshow(Integer n){
        return goodsService.downgoods(n);
    }
}
