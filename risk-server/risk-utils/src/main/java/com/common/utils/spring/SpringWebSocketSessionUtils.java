package com.common.utils.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/9/1.
 */
public class SpringWebSocketSessionUtils  {

    private static final Logger logger = LoggerFactory.getLogger(SpringWebSocketSessionUtils.class);

    private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();


    /**
     * 保存连接
     * @param sessionId
     * @param session
     */
    public static void add(String sessionId, WebSocketSession session){
        clients.put(sessionId, session);
    }

    /**
     * 获取连接
     * @param sessionId
     * @return
     */
    public static WebSocketSession get(String sessionId){
        return clients.get(sessionId);
    }

    /**
     *  删除连接
     * @param sessionId
     * @throws IOException
     */
    public static void remove(String sessionId) throws IOException {
        clients.remove(sessionId);
    }


    /**
     * 判断是否有效连接
     * @param sessionId
     * @return
     */
    public static boolean hasConnection(String sessionId) {
        return clients.containsKey(sessionId);
    }

    /**
     * 获取连接数的数量
     * @return
     */
    public static int getSize() {
        return clients.size();
    }

    /**
     * 发送消息到客户端
     * @param sessionId
     * @param message
     * @throws Exception
     */
    public static void sendMessage(String sessionId, String message) {

        try {
            if (!hasConnection(sessionId)) {
                throw new NullPointerException(sessionId + " connection does not exist");
            }

            WebSocketSession session = get(sessionId);
            session.sendMessage(new TextMessage(message));
        } catch (Exception e) {
            logger.error("websocket sendMessage exception: " + sessionId);
            logger.error(e.getMessage(), e);
            clients.remove(sessionId);
        }
    }


}
