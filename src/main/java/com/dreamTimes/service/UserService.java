package com.dreamTimes.service;


import com.dreamTimes.beans.Page;
import com.dreamTimes.dto.Userdto;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 登录业务
     */
    String loginService(String telephone, String password, HttpServletRequest req);

    /**
     * 用户管理的分页实现
     * @param pagen
     * @return
     */
    Page userManage(Integer pagen);

    /**
     * 判断注册用户是否存在
     * @param userdto
     * @return
     */
    String registerJudge(Userdto userdto);

    /**
     * 用户管理的分页实现
     * @param pagen
     * @return
     */
    Page userforbiden(Integer pagen);
}
