package com.risk.web.ws;

import com.common.utils.spring.SpringWebSocketSessionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Administrator on 2016/9/1.
 */
public class MyWebSocketHandler implements WebSocketHandler {
    /**
     * webscoket建立好链接之后的处理函数
     * @param session 当前websocket的会话id，打开一个websocket通过都会生成唯一的一个会话，可以通过该id进行发送消息到浏览器客户端
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        SpringWebSocketSessionUtils.add(MapUtils.getString(session.getAttributes(), "sessionId"), session);
    }


    /**
     * 客户端发送服务器的消息时，的处理函数，在这里收到消息之后可以分发消息
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //收到消息啥都不干
       String body = (String)message.getPayload();

    }

    /**
     * 消息传输过程中出现的异常处理函数
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        SpringWebSocketSessionUtils.remove(MapUtils.getString(session.getAttributes(), "sessionId"));
    }


    /**
     * websocket链接关闭的回调
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        SpringWebSocketSessionUtils.remove(MapUtils.getString(session.getAttributes(), "sessionId"));
    }

    /**
     * 是否支持处理拆分消息，返回true返回拆分消息
     */
    @Override
    public boolean supportsPartialMessages() {
        // TODO Auto-generated method stub
        return false;
    }
}
