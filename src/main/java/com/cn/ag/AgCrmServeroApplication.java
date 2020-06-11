package com.cn.ag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.cn.ag.data.dao.xml")
public class AgCrmServeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgCrmServeroApplication.class, args);
	}

}
