package com.mmc.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DataSourceConfig {

    @Value("${shop.jdbc.url}")
    private String url;
    @Value("${shop.jdbc.username}")
    private String username;
    @Value("${shop.jdbc.password}")
    private String password;
    private Integer initialSize=50;
    private Integer maxActive=200;
    private Integer maxWait=5000;
    private Integer minIdle=10;
    private String validationQuery="SELECT 1";



    @Bean(initMethod ="init")
    public DataSource getDataSource() {
        log.info("数据库初始化...");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);// 用户名
        dataSource.setPassword(password);// 密码
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setValidationQuery(validationQuery);
        return dataSource;
    }

    public String getUrl() {
     return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
