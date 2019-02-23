package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.service.GreetService;

@Service("chinese")
public class ChineseGreetServiceImpl implements GreetService {

	@Override
	public Map<String, String> sayHello() {
		Map<String, String> map = new HashMap<>();
		map.put("say", "你好！！！");
		System.out.println("map=="+map);
		return map;
	}

}
