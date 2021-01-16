package com.francis.alibaba.service;

import com.francis.alibaba.entity.Order;
import com.francis.common.entity.ResultVo;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 0:33
 */
public interface OrderService {

    ResultVo createOrder(Order order);

    Order queryById(int id);
}
