package me.leonorader.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomInput {

    private Integer floor;

    private Integer room;

    private String colour;

}
