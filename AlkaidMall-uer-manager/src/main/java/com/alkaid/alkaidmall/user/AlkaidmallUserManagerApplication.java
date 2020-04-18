package com.alkaid.alkaidmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.alkaid.alkaidmall.user.mapper")
public class AlkaidmallUserManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlkaidmallUserManagerApplication.class, args);
	}

}
