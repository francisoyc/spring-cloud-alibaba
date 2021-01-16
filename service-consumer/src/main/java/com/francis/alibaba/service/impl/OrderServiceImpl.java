package com.francis.alibaba.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.francis.alibaba.dao.OrderDao;
import com.francis.alibaba.entity.Order;
import com.francis.alibaba.service.OrderService;
import com.francis.common.entity.ResultVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/14 0:34
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RestTemplate restTemplate;

    @GlobalTransactional(name = "francis-create-order", rollbackFor = Exception.class)
    @Override
    public ResultVo createOrder(Order order) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("commodityCode", order.getCommodityCode());
        params.add("count", order.getCount());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);
        String url = "http://service-provider/seata/storage/decrease";
        ResponseEntity<ResultVo> entity = restTemplate.postForEntity(url, request, ResultVo.class);
        log.info("===== response ===== {}", entity.getBody());
        if (entity.getStatusCode() == HttpStatus.OK && entity.getBody().getCode() == 0) {
            orderDao.insert(order);
            System.out.println(1/0);
            return new ResultVo().success(order.getId());
        }
        return new ResultVo().failed("创建订单失败");
    }

    @SentinelResource(value = "getOrder")
    @Override
    public Order queryById(int id) {
        return orderDao.queryById(id);
    }

}
