package com.risk.web.ws.controller;

import com.common.utils.spring.SpringWebSocketSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/9/1.
 */
@Controller
@RequestMapping("/ws")
//@MessageMapping("foo")
public class WebSocketController {

//    @Autowired
//    private SimpMessagingTemplate template;

//    @MessageMapping("handle")
//    @SendTo("/topic/greetings")
    public String handle(String name) {
        System.out.println("hello");
        return "handle2";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Object sendToUserMessage(HttpSession session){
//        template.convertAndSendToUser(session.getId(), "/handler.hell", "hello");
        try {
            SpringWebSocketSessionUtils.sendMessage(session.getId(), "收到没");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "hello";
    }
}
