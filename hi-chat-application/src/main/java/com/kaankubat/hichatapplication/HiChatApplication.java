package com.kaankubat.hichatapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kaankubat.hichatapplication.repository")
@SpringBootApplication
public class HiChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiChatApplication.class, args);
	}

}
