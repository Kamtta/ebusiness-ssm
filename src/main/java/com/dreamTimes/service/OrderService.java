package com.dreamTimes.service;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    /**
     * 添加订单
     * @param req
     */
    String addOrder(HttpServletRequest req);
}
