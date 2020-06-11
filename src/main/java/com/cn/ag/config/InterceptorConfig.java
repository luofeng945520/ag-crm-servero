package com.cn.ag.config;

import com.cn.ag.component.TokenAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName:InterceptorConfig
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/19 22:36
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getTokenAop()).addPathPatterns("/**");
    }

    @Bean
    public TokenAop getTokenAop(){
        return new TokenAop();
    }
}
