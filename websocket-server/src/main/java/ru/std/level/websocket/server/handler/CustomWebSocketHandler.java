package ru.std.level.websocket.server.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class CustomWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Получено сообщение от клиента: " + message.getPayload());

        // Отправка ответа клиенту
        session.sendMessage(new TextMessage("Отправлено сообщение: " + message.getPayload()));
    }
}
