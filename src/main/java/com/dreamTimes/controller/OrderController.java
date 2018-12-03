package com.dreamTimes.controller;

import com.dreamTimes.beans.Order;
import com.dreamTimes.beans.User;
import com.dreamTimes.dao.OrderDao;
import com.dreamTimes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDao orderDao;


    @RequestMapping("ordermanage")
    public String orderManage(){
        return "ordermanage";
    }


    @RequestMapping(value = "manageorder",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> ordermanage(){
        List<Order> list = orderDao.selectAll();
        return list;
    }


    @RequestMapping("order")
    public String order(){
        return "order";
    }


    @RequestMapping(value = "selectByuid",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> selectByuid(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> list = orderDao.selectByUid(user.getUid());
        return list;
    }


    @RequestMapping("delete")
    public String delete(Integer oid){
        orderDao.delete(oid);
        return "ordermanage";
    }


    @RequestMapping("addOrder")
    public String addOrder(HttpServletRequest req){
        return orderService.addOrder(req);
    }
}
