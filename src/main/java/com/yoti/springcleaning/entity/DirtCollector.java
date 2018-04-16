package com.yoti.springcleaning.entity;

import lombok.Data;

@Data
public class DirtCollector {

    private Room room;
    private Coordinate currentLocationInRoom;

    public DirtCollector(Room room, Coordinate initialCoordinate) {
        this.room = room;
        this.currentLocationInRoom = initialCoordinate;
    }
}
