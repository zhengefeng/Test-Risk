package com.risk.web.ws;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * Created by Administrator on 2016/9/1.
 */
@Service
public class MySessionConnectedEvent implements ApplicationListener<SessionConnectedEvent> {

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {

        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage()); //获取消息头



        System.out.println("有人连接了 "+ headers.getSessionId());

    }
}
