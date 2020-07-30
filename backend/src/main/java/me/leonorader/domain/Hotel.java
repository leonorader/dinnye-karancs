package me.leonorader.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Hotel {

    private List<List<Room>> rooms;

    private List<Room> entresol;

    public void init() {
        rooms = new ArrayList<>();
        entresol = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            List<Room> floor = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                floor.add(new Room("#fff", DataType.COLOUR));
            }
            rooms.add(floor);
        }
        for (int i = 0; i < 4; i++) {
            entresol.add(new Room("#fff", DataType.COLOUR));
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

    public void setEntresolColour(String colour) {
        for (int i = 0; i < 4; i++) {
            setEntresolWindowColour(i, colour);
        }
    }

    public void setEntresolWindowColour(int window, String colour) {
        entresol.get(window).setData(colour);
        entresol.get(window).setType(DataType.COLOUR);
    }

    public void setEntresolWindowVideo(int window, String link) {
        entresol.get(window).setData(link);
        entresol.get(window).setType(DataType.VIDEO);
    }

}
