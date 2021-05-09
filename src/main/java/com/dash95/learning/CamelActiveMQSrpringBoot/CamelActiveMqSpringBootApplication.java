package com.dash95.learning.CamelActiveMQSrpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;


@SpringBootApplication
public class CamelActiveMqSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelActiveMqSpringBootApplication.class, args);
	}

}
