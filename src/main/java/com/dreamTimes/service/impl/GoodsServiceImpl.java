package com.dreamTimes.service.impl;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.beans.Page;
import com.dreamTimes.dao.GoodsDao;
import com.dreamTimes.dto.Goodsdto;
import com.dreamTimes.service.GoodsService;
import com.dreamTimes.util.ImgUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> getall() {
        List<Goods> list = goodsDao.getAll();
        return list;
    }

    @Override
    public void addGoods(Goodsdto goodsdto,String servletPath) throws IOException {
        Goods goods = new Goods();
        String path = ImgUtil.imgControl(goodsdto.getGphoto(),servletPath);
        BeanUtils.copyProperties(goodsdto,goods);
        goods.setGphoto(path);
        goodsDao.addGoods(goods);
    }

    @Override
    public Page goodsManage(Integer pagen) {
        if(pagen == 0){
            pagen += 1;
        }
        Page page = new Page();
        page.setCount(goodsDao.sumCount());
        page.setCurrentPage(pagen);
        page.setContent(goodsDao.findContent((pagen-1)*page.getPageCount(),page.getPageCount()));
        return page;
    }

    @Override
    public Page downgoods(Integer pagen) {
        if(pagen == 0){
            pagen += 1;
        }
        Page page = new Page();
        page.setCount(goodsDao.sumCountByIfdelete());
        page.setCurrentPage(pagen);
        page.setContent(goodsDao.findContentByIfdelete((pagen-1)*page.getPageCount(),page.getPageCount()));
        return page;
    }

}
