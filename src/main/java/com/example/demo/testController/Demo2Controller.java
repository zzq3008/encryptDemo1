package com.example.demo.testController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

	@RequestMapping("/test1")
	public Map<String, String> test1(){
		Map<String, String> map = new HashMap<>();
		map.put("a", "a1");
		map.put("b", "b1");
		return map;
	}
	
	@RequestMapping("/test2")
	public Map<String, String> test2(){
		Map<String, String> map = new HashMap<>();
		map.put("a", "a2");
		map.put("b", "b2");
		return map;
	}
	
	@RequestMapping("/test3")
	public Map<String, String> test3(HttpServletRequest req){
		Map<String, String> map = new HashMap<>();
		map.put("a", "a2");
		map.put("b", "b2");
		HttpSession session = req.getSession();
		System.out.println("session="+session.getAttribute("dd"));
		
		return map;
	}
}
