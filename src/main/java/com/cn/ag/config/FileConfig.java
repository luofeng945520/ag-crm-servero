package com.cn.ag.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:FileConfig
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/20 20:55
 */
@Configuration
@ConfigurationProperties(prefix = "file.config")
public class FileConfig {

    /**
     * 获取工单号对应的XML的结构树
     */
    private String getPanelCombination;



    public String getGetPanelCombination() {
        return getPanelCombination;
    }

    public FileConfig setGetPanelCombination(String getPanelCombination) {
        this.getPanelCombination = getPanelCombination;
        return this;
    }
}
