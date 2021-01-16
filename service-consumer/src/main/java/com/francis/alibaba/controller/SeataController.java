package com.francis.alibaba.controller;

import com.francis.alibaba.entity.Order;
import com.francis.alibaba.service.OrderService;
import com.francis.common.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 22:49
 */
@RestController
@RequestMapping("/seata/")
public class SeataController {
    @Autowired
    private OrderService orderService;

    @PostMapping("order/create")
    public ResultVo createOrder(@RequestBody Order order) {
        try {
            return orderService.createOrder(order);
        } catch (Exception e) {
            return new ResultVo().failed("创建订单失败");
        }
    }
}
