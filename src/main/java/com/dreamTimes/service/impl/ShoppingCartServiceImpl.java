package com.dreamTimes.service.impl;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.beans.ShoppingCart;
import com.dreamTimes.dao.GoodsDao;
import com.dreamTimes.dao.ShoppingCartDao;
import com.dreamTimes.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public void addShoppingCart(Integer gid) {
        if(shoppingCartDao.selectByGid(gid) == null){
            Goods goods = goodsDao.select(gid);
            shoppingCartDao.addGoods(goods);
        }else {
            ShoppingCart shoppingCart = shoppingCartDao.selectByGid(gid);
            shoppingCart.setNum(shoppingCart.getNum()+1);
            shoppingCartDao.update(shoppingCart);
        }
    }
}
