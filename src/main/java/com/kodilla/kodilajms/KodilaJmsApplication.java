package com.kodilla.kodilajms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class KodilaJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodilaJmsApplication.class, args);
	}

}
