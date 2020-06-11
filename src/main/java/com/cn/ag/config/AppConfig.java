package com.cn.ag.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:AppConfig
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/19 21:40
 */
@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppConfig {

    private String appName;

    private String secret;

    public String getAppName() {
        return appName;
    }

    public AppConfig setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public AppConfig setSecret(String secret) {
        this.secret = secret;
        return this;
    }
}
