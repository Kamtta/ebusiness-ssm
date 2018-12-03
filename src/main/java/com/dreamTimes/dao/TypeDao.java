package com.dreamTimes.dao;


import com.dreamTimes.beans.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDao {
    /**
     * 查询所有的类型
     * @return
     */
//    @Select("select * from typetable")
    List<Type> selectAll();

    /**
     * 根据tid进行删除
     */
    int deleteByTname(@Param("tname") String tname);
}
