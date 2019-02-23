var socket;
if(typeof(WebSocket) == "undefined") {
	console.log("您的浏览器不支持WebSocket");
}else{
	console.log("您的浏览器支持WebSocket");
	//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
	console.log(111)
	//socket = new WebSocket("ws://localhost:9094/starManager/websocket/张三")
	socket = new WebSocket("ws://localhost:8888/chat/aaa-sdfdsf-sef3234sdfds2324");
	
	// 打开事件
	socket.onopen = function() {
		console.log("Socket 已打开");
		// socket.send("这是来自客户端的消息" + location.href + new Date());

	};

	// 获得消息事件
	socket.onmessage = function(evt) {
		if (typeof (evt.data) == "string") {
			setMessageInnerHTML(evt.data);
		} else {
			var reader = new FileReader();
			console.log(1)
			reader.onload = function(evt) {
				if (evt.target.readyState == FileReader.DONE) {
					var url = evt.target.result;
					
					var img = document.getElementById("imgDiv");
					img.innerHTML = "<img src = " + url + " />";
				}
			}
			reader.readAsDataURL(evt.data);
		}
		
//		 console.log(msg.data);
//		 // 发现消息进入 调后台获取
//		 //getCallingList();
//		 setMessageInnerHTML(msg.data)
	};

	// 关闭事件
	socket.onclose = function() {
		console.log("Socket已关闭");
	};

	// 发生了错误事件
	socket.onerror = function() {
		//alert("Socket发生了错误");
		console.log("被关闭")
//		while socket.
		
	}


}
//将消息显示在网页上
  function setMessageInnerHTML(innerHTML){
    document.getElementById('message').innerHTML += innerHTML + '<br/>';
  }
 
  //关闭连接
  function closeWebSocket(){
    socket.close();
  }
 
  //发送消息
  function send(){
    var message = document.getElementById('text').value;
    socket.send(message);
  }
//  $("#btnSend").click(function() {
//       socket.send("这是来自客户端的消息" + location.href + new Date());
//  });
//