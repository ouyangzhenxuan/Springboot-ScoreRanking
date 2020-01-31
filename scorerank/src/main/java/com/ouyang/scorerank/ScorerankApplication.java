package com.ouyang.scorerank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.ouyang.scorerank.dao")
@RestController
public class ScorerankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorerankApplication.class, args);
	}

}
