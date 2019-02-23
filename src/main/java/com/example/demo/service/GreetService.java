package com.example.demo.service;

import java.util.Map;

import org.ff4j.aop.Flip;

@Flip(name="greetService", alterBean="chinese")
public interface GreetService {

	Map<String, String> sayHello();
	
}
