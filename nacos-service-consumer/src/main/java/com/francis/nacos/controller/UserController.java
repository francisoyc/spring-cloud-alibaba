package com.francis.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: francis
 * @description:
 * @date: 2020/11/30 21:36
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/info/{id}")
    public String getUserInfo(@PathVariable Integer id) {
        String url = "http://nacos-service-provider/user/info/" + id;
        final ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        return entity.getBody();
    }
}
