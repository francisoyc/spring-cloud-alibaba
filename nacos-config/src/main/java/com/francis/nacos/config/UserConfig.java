package com.francis.nacos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: francis
 * @description:
 * @date: 2020/11/29 20:27
 */
@Data
@Component
//@RefreshScope
@ConfigurationProperties(prefix = "user")
public class UserConfig {
    private int id;
    private int age;
    private String name;
}
