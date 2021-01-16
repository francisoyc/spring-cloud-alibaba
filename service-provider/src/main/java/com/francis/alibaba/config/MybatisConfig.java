package com.francis.alibaba.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: francis
 * @description:
 * @date: 2021/1/13 6:56
 */
@Configuration
@MapperScan(basePackages = "com.francis.alibaba.dao")
public class MybatisConfig {

    /*@Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    DataSource hikariDataSource() {
        return new HikariDataSource();
    }*/

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean
    DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    /*@Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/*.xml"));
        // sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.francis.alibaba.entity");
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        return sqlSessionFactoryBean;
    }*/
}
