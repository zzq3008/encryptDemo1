package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.service.GreetService;

@Service("english")
public class EnglishGreetServiceImpl implements GreetService {

	@Override
	public Map<String, String> sayHello() {
		Map<String, String> map = new HashMap<>();
		map.put("say", "hello！！");
		System.out.println("map=="+map);
		return map;
	}

}
