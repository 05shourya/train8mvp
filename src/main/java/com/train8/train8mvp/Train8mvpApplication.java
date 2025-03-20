package com.train8.train8mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class Train8mvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Train8mvpApplication.class, args);
	}

}
