package me.leonorader;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import me.leonorader.websocket.HotelHandler;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final HotelHandler hotelHandler;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        hotelHandler.init();
    }
}
