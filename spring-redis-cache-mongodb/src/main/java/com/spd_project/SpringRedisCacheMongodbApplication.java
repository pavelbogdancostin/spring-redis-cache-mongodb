package com.spd_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringRedisCacheMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCacheMongodbApplication.class, args);
	}
}
