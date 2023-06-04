package ru.std.level.websocket.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class PetSocketClientApp {

    private static WebSocketSession session;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PetSocketClientApp.class, args);

        // Установка соединения с сервером
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketClientHandler webSocketClientHandler = new WebSocketClientHandler();
        WebSocketConnectionManager connectionManager =
                new WebSocketConnectionManager(webSocketClient, webSocketClientHandler, "ws://localhost:8080/websocket");
        connectionManager.start();
        System.out.println("Start");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    sendMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void sendMessages() throws IOException {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                    String next = sc.next();
                    session.sendMessage(new TextMessage(next));
                    if (next.equals("stop")) {
                        session.close();
                        break;
                    }
                }
            }
        };
        runnable.run();

    }

    private static class WebSocketClientHandler extends TextWebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
            System.out.println("Соединение установлено.");
            session = webSocketSession;
            // Отправка сообщения на сервер
            webSocketSession.sendMessage(new TextMessage("Привет, сервер!"));
        }

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) {
            System.out.println("Получен ответ от сервера: " + message.getPayload());
        }
    }
}
