package com.francis.alibaba.controller;

import com.francis.alibaba.entity.Order;
import com.francis.alibaba.service.OrderService;
import com.francis.common.entity.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/15 0:33
 */
@RestController
@RequestMapping("/sentinel/")
public class SentinelController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @GetMapping("user/{id}")
    public ResultVo getUser(@PathVariable int id) {
        ResponseEntity<ResultVo> entity = restTemplate.getForEntity(
                "http://service-provider/sentinel/user/" + id, ResultVo.class);
        return entity.getBody();
    }


    /**
     * getOrderA 和 getOrderB 测试限流规则为链路模式的
     * @return
     */
    @GetMapping("order/a")
    public ResultVo<Order> getOrderA() {
        return new ResultVo<>().success(orderService.queryById(1));
    }

    @GetMapping("order/b")
    public ResultVo<Order> getOrderB() {
        return new ResultVo<>().success(orderService.queryById(2));
    }
}
