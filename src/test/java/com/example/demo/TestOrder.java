package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.example.demo.base.util.AesEncryptUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestOrder {

	static HttpClient httpClient = new HttpClient();
	
	

	public static void main(String[] args) throws Exception {
		test1();
		
	}

	
	
	
	
private static void test1() throws Exception {
		String url = "http://localhost:8080/test2";
		
		
		
		System.out.println("接口：== " + url);
			
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "hello");
		map.put("key1", "world");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		String resultReq =  AesEncryptUtils.aesEncrypt(content, "abcdef0123456789");
		
		ObjectMapper mapper = new ObjectMapper();  
		mapper.setSerializationInclusion(Include.NON_NULL); 
        String json = mapper.writeValueAsString(resultReq);  
		
        String result= doPost(url, json);
		
		System.out.println("返回值：== " + result);
	}
	

	
	
	public static String login(String phone, String pass) {

		// 登陆 Url
		String loginUrl = "http://localhost:8080/user/login";

		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		PostMethod postMethod = new PostMethod(loginUrl);

		// 设置登陆时要求的信息，用户名和密码
		NameValuePair[] data = { new NameValuePair("phone", "1"), new NameValuePair("pass", "1") };
		postMethod.setRequestBody(data);
		try {
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");

			}
			
			
			return postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUrl;
	}

	/**
	 * 
	 * @param strUrl
	 * @param postString
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String doPost(String strUrl, String postString) {
		String receive = null;

		// 请求发布在本地 Tomcat上服务
		PostMethod method = new PostMethod(strUrl);
		// PostMethod method = new PostMethod();
		try {
			// client.getHostConfiguration().setHost(new HttpHost());

			// 请求 网络上的服务, 用这种方式请求本地,返回一个Html页面
			// client.getHostConfiguration().setHost(new URI(strUrl));

			method.setRequestHeader("Content-type", "application/json; charset=UTF-8");
			method.setRequestHeader("Accept", "application/json; charset=UTF-8");
			method.setRequestHeader("token", "083bbcc5-f84e-4b0a-bfd8-8dc25cf4a05e");
//			method.setRequestHeader("token", "09e26b02-7e31-4418-83b1-52ceda3c6946");
			// 设置为默认的重试策略
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

			method.setRequestBody(postString);
			int rspCode = httpClient.executeMethod(method);
			//
			receive = method.getResponseBodyAsString();
			return receive;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return receive;
	}
	
	
	
	public static String get(String phone, String pass) {

		// 登陆 Url
		String loginUrl = "http://localhost:8080/goods/getById";

		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		PostMethod postMethod = new PostMethod(loginUrl);

		// 设置登陆时要求的信息，用户名和密码
		NameValuePair[] data = { new NameValuePair("id", "1")};
		postMethod.setRequestBody(data);
		try {
			// 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
			}
			
			
			return postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUrl;
	}
}