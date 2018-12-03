package com.dreamTimes.service.impl;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.beans.Order;
import com.dreamTimes.beans.ShoppingCart;
import com.dreamTimes.beans.User;
import com.dreamTimes.dao.GoodsDao;
import com.dreamTimes.dao.OrderDao;
import com.dreamTimes.dao.ShoppingCartDao;
import com.dreamTimes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrderDao orderDao;
    @Override
    public String addOrder(HttpServletRequest req) {
        List<ShoppingCart> list = shoppingCartDao.selectAll();
        if(list == null){
            return "shoppingcart";
        }
        for (int i = 0; i < list.size();i++){
            Order order = new Order();
            ShoppingCart shoppingCart = list.get(i);
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            Goods goods = goodsDao.select(shoppingCart.getGid());
            goods.setGsalevolume(goods.getGsalevolume()+shoppingCart.getNum());
            goods.setGrepertory(goods.getGrepertory()-shoppingCart.getNum());
            goodsDao.updategoods(goods);
            order.setGid(goods.getGid());
            order.setGnum(shoppingCart.getNum());
            order.setGphoto(goods.getGphoto());
            order.setoNum(String.valueOf(goods.getGname().hashCode()+Math.random()*100));
            order.setOcreatedate(new Date(System.currentTimeMillis()));
            order.setUid(user.getUid());
            orderDao.addOrder(order);
        }
        for (int i = 0;i<list.size();i++){
            shoppingCartDao.delete(list.get(i).getSid());
        }
        return "order";
    }
}
