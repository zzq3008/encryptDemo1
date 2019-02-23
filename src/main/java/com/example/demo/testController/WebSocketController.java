package com.example.demo.testController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.WebSocketServer;

@Controller
public class WebSocketController {

//	@Autowired
//    private SimpMessagingTemplate messagingTemplate;
	
	@RequestMapping("/webSocketDemo")
	public String webSocketDemo(){
		return "webSocketDemo";
	}
	
	@RequestMapping("/talk")
	public String talk(){
		return "talk";
	}
	
	@RequestMapping(value="/pushVideoListToWeb",method=RequestMethod.POST,consumes = "application/json")
	 public @ResponseBody Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
		 Map<String,Object> result =new HashMap<String,Object>();
		 try {
			 WebSocketServer.sendInfo("有新客户呼入,userId:"+param.get("userId"));
			 result.put("operationResult", true);
		 }catch (IOException e) {
			 result.put("operationResult", true);
		 }
		 return result;
	 }
	
//    @MessageMapping("/send")
//    @SendTo("/topic/send")
//    public SocketMessage send(SocketMessage message) throws Exception {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        message.date = df.format(new Date());
//        return message;
//    }
//
//    @Scheduled(fixedRate = 1000)
//    @SendTo("/topic/callback")
    public Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WebSocketServer.sendInfo(df.format(new Date()));
        return "callback";
    }
	
}

	class SocketMessage{
		public String message;

	    public String date;

	}
