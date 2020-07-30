package me.leonorader.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import me.leonorader.domain.ColourInput;
import me.leonorader.domain.DataType;
import me.leonorader.domain.EntresolInput;
import me.leonorader.domain.Hotel;
import me.leonorader.domain.MatrixInput;
import me.leonorader.domain.RoomInput;
import me.leonorader.domain.WindowInput;
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
    public void setColour(@RequestBody ColourInput colourInput) throws IOException {
        hotelHandler.getHotel().setHotelColour(colourInput.getColour());
        sendHotel();
    }

    @PutMapping("/matrix")
    public void setMatrix(@RequestBody MatrixInput matrixInput) throws IOException {
        hotelHandler.getHotel().setHotelMatrix(matrixInput.getData());
        sendHotel();
    }

    @PutMapping("/rooms")
    public void setRoom(@RequestBody RoomInput roomInput) throws IOException {
        hotelHandler.getHotel().setRoomColour(roomInput.getFloor(), roomInput.getRoom(), roomInput.getColour());
        sendHotel();
    }

    @PutMapping("/entresol")
    public void setEntresolColour(@RequestBody EntresolInput entresolInput) throws IOException {
        for(int i = 0; i < 4; i++) {
            hotelHandler.getHotel().setEntresolWindowColour(i, entresolInput.getData().get(i));
        }
        sendHotel();
    }

    @PutMapping("/entresol/window")
    public void setEntresolWindowColour(@RequestBody WindowInput windowInput) throws IOException {
        if (windowInput.getType() == DataType.COLOUR) {
            hotelHandler.getHotel().setEntresolWindowColour(windowInput.getWindow(), windowInput.getData());
        } else {
            hotelHandler.getHotel().setEntresolWindowVideo(windowInput.getWindow(), windowInput.getData());
        }
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
