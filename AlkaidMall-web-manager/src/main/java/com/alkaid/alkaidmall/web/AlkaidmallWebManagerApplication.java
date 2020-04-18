package com.alkaid.alkaidmall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.alkaid.alkaidmall")
public class AlkaidmallWebManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlkaidmallWebManagerApplication.class, args);
	}

}
