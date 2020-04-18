package com.alkaid.alkaidmall.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.alkaid.alkaidmall.manager")
public class AlkaidmallServiceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlkaidmallServiceManagerApplication.class, args);
	}

}
