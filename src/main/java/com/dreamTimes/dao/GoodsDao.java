package com.dreamTimes.dao;



import com.dreamTimes.beans.Goods;
import com.dreamTimes.dto.Goodsdto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 计算level中的总条数
     * @return
     */
    int sumCount();

    /**
     * 找出对应等级的相应信息
     * @param offset
     * @param num
     * @return
     */
    List findContent(@Param("offset") int offset, @Param("num") int num);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(@Param("goods") Goods goods);

    /**
     * 删除商品
     * @param gid
     * @return
     */
    int deletegoods(@Param("gid") int gid);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    int updategoods(@Param("goods") Goods goods);

    /**
     * 根据商品序号进行查询
     * @param gid
     * @return
     */
    Goods select(@Param("gid") Integer gid);

    /**
     * 根据商品名进行查询
     * @param gname
     * @return
     */
    List<Goods> selectAll(@Param("gname") String gname);

    /**
     * 根据tid进行删除
     */
    int deleteByTname(@Param("tname") String tname);

    List<Goods> getAll();

    /**
     *
     * @return
     */
    List<Goods> findContentByIfdelete(@Param("offset") int offset, @Param("num") int num);

    /**
     * 计算下架商品中的总条数
     * @return
     */
    int sumCountByIfdelete();
}
