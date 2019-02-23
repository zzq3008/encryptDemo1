package com.example.demo.testController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyHttpClient {

	private static List<String> history = new ArrayList<>();
	//创建HttpClient对象
	static HttpClient hClient = new DefaultHttpClient();
	
	private static Map<String, Integer> calmap = new HashMap<>();
	
	@RequestMapping("getUrl")
	@ResponseBody
	public Map<String, String> getWeb(String url){
		Map<String, String> map=new HashMap<>();
		try {
			map.put("body", get(url));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
//	public static void main(String[] args) throws ClientProtocolException, IOException {
//		
//		System.out.println("==============================================");
//		System.out.println(get(100));
//	}
	
	
	
	
	public String get(String url) throws ClientProtocolException, IOException{
		//设置响应时间，设置传智源码时间，设置代理服务器
		hClient.getParams()
		.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000)
		.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000)
//				.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("118.81.73.228",9797))
		;
		HttpGet hget2 = null;
		HttpResponse response2 = null;
		String content2 = null;
		Document doc2 = null;
		Elements element2 = null;
		Elements es = null;
		int index = 0;
		
		hget2 = new HttpGet(url);
		response2 = hClient.execute(hget2);
		content2 = EntityUtils.toString(response2.getEntity(), "utf-8");
		doc2 = Jsoup.parse(content2);
		element2 = doc2.select("body");
		return element2.html();
	}
	
	
	
	
}
