package com.cn.ag.component;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * @ClassName:jdbcComponent
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/13 22:38
 */
@Configuration
public class JdbcComponent {

    @Bean(name="dataSourceM")
    @Primary
    @ConfigurationProperties(prefix = "jdbc.m")
    public DataSource dataSourceM(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sqlSessionFactoryBeanM")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryBeanM(@Qualifier("dataSourceM") DataSource ds) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        //加载mapper.xml 文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/cn/ag/data/dao/xml/**/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean(name="dataSourceZ")
    @ConfigurationProperties(prefix = "jdbc.z")
    public DataSource dataSourceZ(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sqlSessionFactoryBeanZ")
    public SqlSessionFactoryBean sqlSessionFactoryBeanZ(@Qualifier("dataSourceZ") DataSource ds) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        //加载mapper.xml 文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/cn/ag/data/dao/xml/**/*.xml"));
        return sqlSessionFactoryBean;
    }

}
