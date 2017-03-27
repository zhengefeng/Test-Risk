package com.risk.web.ws;

import com.common.utils.constant.RiskConstants;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Administrator on 2016/8/31.
 */
public class WebsocketEndPoint extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {

        Object obj = session.getAttributes().get(RiskConstants.USER_SESSION_KEY);
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");
        session.sendMessage(returnMessage);
    }
}