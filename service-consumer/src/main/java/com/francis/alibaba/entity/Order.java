package com.francis.alibaba.entity;

import lombok.Data;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/13 7:14
 */
@Data
public class Order {
    private int id;
    private String userId;
    private String commodityCode;
    private int count;
    private int money;
}
