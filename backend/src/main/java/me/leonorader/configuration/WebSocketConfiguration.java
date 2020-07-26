package me.leonorader.configuration;

import lombok.RequiredArgsConstructor;
import me.leonorader.websocket.HotelHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@Controller
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final HotelHandler hotelHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(hotelHandler, "/socket/hotel").setAllowedOrigins("*");
    }
}
