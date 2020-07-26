package me.leonorader.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Hotel {

    private List<List<Room>> rooms;
    // entresol

    public void init() {
        rooms = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            List<Room> floor = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                floor.add(new Room("#fff", DataType.COLOUR));
            }
            rooms.add(floor);
        }
    }

    public void setHotelColour(String colour) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                setRoomColour(i, j, colour);
            }
        }
        // TODO set entresol
    }

    public void setHotelMatrix(List<List<String>> data) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                setRoomColour(i, j, data.get(i).get(j));
            }
        }
    }

    public void setRoomColour(int floor, int room, String colour) {
        rooms.get(floor).get(room).setData(colour);
    }

}
