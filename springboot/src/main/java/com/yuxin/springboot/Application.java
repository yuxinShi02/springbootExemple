package com.yuxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"com.yuxin.springboot.dao"})
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
