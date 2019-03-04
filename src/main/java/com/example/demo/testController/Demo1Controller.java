package com.example.demo.testController;

import java.util.HashMap;
import java.util.Map;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.base.anno.Decrypt;
import com.example.demo.base.anno.Encrypt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("swagger ui 注释 api 级别")
@RequestMapping("/test")
public class Demo1Controller {
	
//	@ApiOperation("swagger ui 注释 方法级别")
	@Encrypt
	@PostMapping("test1")
	public Map<String, String> test1(@RequestBody Map<String, String> mapp){
		Map<String, String> map = new HashMap<>();
		map.put("key1", "hello");
		map.put("name", "lily1");
		return map;
	}
	
	@Decrypt
	@Encrypt
	@PostMapping("test2")
	public Map<String, String> test2(@RequestBody Map<String, String> map){
		System.out.println(map);
		return map;
	}
	
	@ApiOperation("swagger ui 注释 方法级别")
	@PostMapping("test3")
	public String test3(String aa, String bb){
		return aa+bb;
	}
	
}