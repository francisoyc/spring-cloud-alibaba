package com.francis.alibaba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@Slf4j
public class ProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    /*@Configuration
    public class FilterContextConfig {
        @Bean
        public FilterRegistrationBean sentinelFilterRegistration() {
            FilterRegistrationBean registration = new FilterRegistrationBean();
            registration.setFilter(new CommonFilter());
            registration.addUrlPatterns("/*");
            // 入口资源关闭聚合
            registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
            registration.setName("sentinelFilter");
            registration.setOrder(1);
            return registration;
        }
    }*/

}
