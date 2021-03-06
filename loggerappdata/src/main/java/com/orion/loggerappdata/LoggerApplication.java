package com.orion.loggerappdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@ComponentScan(basePackages = "com.orion.loggerappdata")
//@EnableElasticsearchRepositories
public class LoggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoggerApplication.class, args);
	}

}
