package me.leonorader.websocket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import me.leonorader.domain.Hotel;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Log
@Component
@RequiredArgsConstructor
public class HotelHandler extends TextWebSocketHandler {

    private final SessionRegistry registry;

    @Getter
    private final Hotel hotel;

    public void init() {
        hotel.init();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        registerSession(session);
        log.info("registered new session: " + session.getId());
    }

    private void registerSession(WebSocketSession session) throws IOException {
        registry.register(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
        registry.removeBySessionId(session.getId());
        log.info("session closed: " + session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String clientMessage = message.getPayload();
        log.info(clientMessage);
        session.sendMessage(new TextMessage("{\"message\": \"pong\"}"));
    }

}
