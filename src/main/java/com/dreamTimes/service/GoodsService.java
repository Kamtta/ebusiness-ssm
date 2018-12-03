package com.dreamTimes.service;

import com.dreamTimes.beans.Goods;
import com.dreamTimes.beans.Page;
import com.dreamTimes.dto.Goodsdto;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface GoodsService {
    /**
     * 获取所有的商品
     * @return
     */
    List<Goods> getall();

    /**
     * 添加商品
     * @param goodsdto
     */
    void addGoods(@Param("goodsdto") Goodsdto goodsdto,@Param("servletPath") String servletPath) throws IOException;

    /**
     * 获取分页对象
     * @param pagen
     * @return
     */
    Page goodsManage(Integer pagen);

    /**
     * 获取分页对象
     * @param pagen
     * @return
     */
    Page downgoods(Integer pagen);
}
