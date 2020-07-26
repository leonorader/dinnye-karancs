package me.leonorader.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import me.leonorader.domain.ColourInput;
import me.leonorader.domain.Hotel;
import me.leonorader.domain.RoomInput;
import me.leonorader.websocket.HotelHandler;
import me.leonorader.websocket.SessionRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelRestController {

    private final SessionRegistry registry;

    private final HotelHandler hotelHandler;

    private final ObjectMapper objectMapper;

    @GetMapping("/")
    public Hotel getHotel() {
        return hotelHandler.getHotel();
    }

    @PutMapping("/colour")
    public void setColour(@RequestBody ColourInput colour) throws IOException {
        hotelHandler.getHotel().setHotelColour(colour.getColour());
        sendHotel();
    }

    @PutMapping("/matrix")
    public void setMatrix(@RequestBody String[][] data) throws IOException {
        hotelHandler.getHotel().setHotelMatrix(data);
        sendHotel();
    }

    @PutMapping("/rooms")
    public void setRoom(@RequestBody RoomInput roomInput) throws IOException {
        hotelHandler.getHotel().setRoomColour(roomInput.getFloor(), roomInput.getRoom(), roomInput.getColour());
        sendHotel();
    }

    private void sendHotel() throws IOException {
        String hotelData = objectMapper.writeValueAsString(hotelHandler.getHotel());

        ObjectNode data = JsonNodeFactory.instance.objectNode();
        data.put("id", "hotel");
        data.put("data", hotelData);
        registry.broadcast(data);
    }

}
