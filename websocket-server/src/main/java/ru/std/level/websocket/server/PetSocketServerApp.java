package ru.std.level.websocket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.std.level.websocket.server.handler.CustomWebSocketHandler;

@EnableWebSocket
@SpringBootApplication
public class PetSocketServerApp implements WebSocketConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(PetSocketServerApp.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/websocket").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new CustomWebSocketHandler();
    }
}
