package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.example.demo.base.anno.EnableEncrypt;


@EnableScheduling
@EnableEncrypt
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.example.demo")
public class EncryptDemoApplication {

	public static void main(String[] args) { 
		SpringApplication.run(EncryptDemoApplication.class, args);
	}
}
