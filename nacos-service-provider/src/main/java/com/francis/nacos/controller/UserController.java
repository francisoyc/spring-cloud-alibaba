package com.francis.nacos.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2020/11/30 21:36
 */
@RestController
@RefreshScope
public class UserController {
    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;

    @Value("${user.id}")
    private int id;

    @GetMapping("/user/info/{id}")
    public String getUserInfo(@PathVariable Integer id) {
        if (ObjectUtils.notEqual(id, this.id)) {
            return "user is not exists";
        }
        return "name=" + name +", age=" + age;
    }

}
