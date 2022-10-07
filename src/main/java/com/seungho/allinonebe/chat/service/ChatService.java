package com.seungho.allinonebe.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@ServerEndpoint(value = "/v1/chat")
public class ChatService {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session s) {
        log.info("open session: {}", s);
        clients.add(s);
    }

    @OnClose
    public void onClose(Session s) {
        log.info("close session: {}", s);
        clients.remove(s);
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        log.info("session({})on message: {}", session, msg);
        clients.forEach(s -> {
            try {
                s.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
