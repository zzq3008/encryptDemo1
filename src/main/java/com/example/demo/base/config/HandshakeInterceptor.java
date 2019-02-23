package com.example.demo.base.config;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * 类说明
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{  
	@Override  
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {  
        //attributes是session里面的所有属性的map表示
        
		String user = request.getURI().getPath().split("\\/")[2];
		attributes.put("user", user);
        return super.beforeHandshake(request, response, handler, attributes);  
    } 
	
    @Override  
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {  
        super.afterHandshake(request, response, wsHandler, ex);  
    }        
    
    //这里没做控制，所以聊天室内的人物名称可能发生重复
    public String getRandomNickName(){
    	String[] nickNameArray={"Captain America","Deadpool","Hawkeye","Hulk","Iron Man","Spider Man","Thor","Wolverine","Black Panther","Colossus"};
    	Random random=new Random();
    	return nickNameArray[random.nextInt(10)];
    }
}  
