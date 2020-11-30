package com.francis.nacos.controller;

import com.francis.nacos.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: francis
 * @description:
 * @date: 2020/11/29 20:10
 */
@RestController
@RefreshScope
public class NacosController {

    @Value("${user.age}")
    private int age;
    @Value(value = "${user.name}")
    private String name;

    @Autowired
    private UserConfig userConfig;

    @GetMapping("/test")
    public String test() {
//        final ConfigService configService = nacosConfigManager.getConfigService();
//        final NacosConfigProperties nacosConfigProperties = nacosConfigManager.getNacosConfigProperties();
        System.out.println(">>>>>>>>>>>>>>>>> " + userConfig.toString());
        return "name=" + name + ", age=" + age;
    }
}
