package com.dreamTimes.dao;

import com.dreamTimes.beans.User;
import com.dreamTimes.dto.Userdto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 计算level中的总条数
     * @param rlevel
     * @return
     */
    int sumCount(@Param("rlevel") Integer rlevel);

    /**
     * 计算level中封号的总条数
     * @param rlevel
     * @return
     */
    int sumCountByIfdelete(@Param("rlevel") Integer rlevel);

    /**
     * 找出对应等级的相应信息
     * @param rlevel
     * @param offset
     * @param num
     * @return
     */
    List findContent(@Param("rlevel") Integer rlevel, @Param("offset") Integer offset, @Param("num") Integer num);
    /**
     * 找出对应等级的相应信息
     * @param rlevel
     * @param offset
     * @param num
     * @return
     */
    List findContentByIfdelete(@Param("rlevel") Integer rlevel, @Param("offset") Integer offset, @Param("num") Integer num);
    /**
     * 根据rlevel进行查询，0为普通用户，1为VIP，2为管理员
     * */
    List<User> selectByRlevel(@Param("rlevel") Integer rlevel);

    /**
     * 根据用户名和level进行查询
     * @param uname
     * @return
     */
    User selectByUname(@Param("uname") String uname, @Param("rlevel") Integer rlevel);

    /**
     * 根据用户名和level进行查询
     * @param uname
     * @return
     */
    User selectByname(@Param("uname") String uname);

    /**
     * 根据相关的用户名进行查询
     * @param uname
     * @return
     */
    List<User> selectByName(@Param("uname") String uname);

    /**
     * 添加管理员
     */
    int insertAdmin(@Param("user") User user);

    /**
     * 根据账号进行删除
     * 对ifdelete进行修改
     * @param uname
     * @return
     */
    int deleteAdmin(@Param("uname") String uname);

    /**
     * 根据账号进行更新
     * @param user
     * @return
     */
    int updateAdmin(@Param("user") Userdto user);

    /**-+
     *
     *
     *
     * .0
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") Userdto user);

    /**
     * 解禁用户
     * @param uid
     * @return
     */
    int unforbidenuser(@Param("uid") Integer uid);
}
