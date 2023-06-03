package ru.std.level.websocket.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@SpringBootApplication
public class PetSocketClientApp {

    public static void main(String[] args) {
        SpringApplication.run(PetSocketClientApp.class, args);

        // Установка соединения с сервером
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(webSocketClient, new WebSocketClientHandler(), "ws://localhost:8080/websocket");
        connectionManager.start();
        System.out.println("Start");
    }

    private static class WebSocketClientHandler extends TextWebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("Соединение установлено.");

            // Отправка сообщения на сервер
            session.sendMessage(new TextMessage("Привет, сервер!"));
        }

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) {
            System.out.println("Получен ответ от сервера: " + message.getPayload());
        }
    }
}
