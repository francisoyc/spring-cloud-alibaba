package com.francis.alibaba;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.francis.alibaba.handler.GlobalExceptionHandler;
import com.francis.alibaba.interceptor.FrancisClientHttpRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    @SentinelRestTemplate(
            blockHandlerClass = GlobalExceptionHandler.class, blockHandler = "handleException",
            fallbackClass = GlobalExceptionHandler.class, fallback = "fallback"
    )
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(new FrancisClientHttpRequestInterceptor()));
        return restTemplate;
    }
}
