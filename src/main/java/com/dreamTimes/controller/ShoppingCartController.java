package com.dreamTimes.controller;

import com.dreamTimes.beans.ShoppingCart;
import com.dreamTimes.dao.ShoppingCartDao;
import com.dreamTimes.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartDao shoppingCartDao;


    @RequestMapping("shoppingcart")
    public String shoppingcart(){
        return "shoppingcart";
    }


    @RequestMapping("addcart")
    public String addGoods(Integer gid){
        shoppingCartService.addShoppingCart(gid);
        return "goods";
    }


    @RequestMapping(value = "showCart",method = RequestMethod.GET)
    @ResponseBody
    public List<ShoppingCart> showShowppingcart(){
        List<ShoppingCart> list = shoppingCartDao.selectAll();
        return list;
    }


    @RequestMapping(value = "deleteShoppingcart",method = RequestMethod.GET)
    public String deleteShoppingcart(Integer sid){
        shoppingCartDao.delete(sid);
        return "shoppingcart";
    }
}
