package com.yoti.springcleaning.entity;

import com.yoti.springcleaning.enums.CardinalDirections;
import lombok.Data;

@Data
public class DirtCollector {

    private Room room;
    private Coordinate currentLocationInRoom;

    public DirtCollector(Room room, Coordinate initialCoordinate) {
        this.room = room;
        this.currentLocationInRoom = initialCoordinate;
    }

    public Coordinate moveInDirection(CardinalDirections direction){
        this.currentLocationInRoom.translateByDisplacementCoordinate(direction.getDisplacementCoordinates());
        this.room.removeDirtyPatch(normalizeCurrentLocationWithinBoundary());
        return this.currentLocationInRoom;
    }

    /**
     * Normalize the current location of dirtCollector within the room's boundaries
     * such that if the location is out of bounds, bring it back within the bounds.
     * @return the current location of dirtCollector within the room
     */
    private Coordinate normalizeCurrentLocationWithinBoundary(){
        if (this.currentLocationInRoom.getX() > 0
                && this.currentLocationInRoom.getX() <= this.room.getMaxCoords().getX()
                && this.currentLocationInRoom.getY() > 0
                && this.currentLocationInRoom.getY() <= this.room.getMaxCoords().getY()){
            return this.currentLocationInRoom;
        }

        if (this.currentLocationInRoom.getX() < 0) {
            this.currentLocationInRoom.setX(0);
        } else { // this.currentLocationInRoom.getX() > this.room.getMaxCoords().getX()
            this.currentLocationInRoom.setX(this.room.getMaxCoords().getX());
        }

        if (this.currentLocationInRoom.getY() < 0){
            this.currentLocationInRoom.setY(0);
        } else { // this.currentLocationInRoom.getY() > this.room.getMaxCoords().getY()
            this.currentLocationInRoom.setY(this.room.getMaxCoords().getY());
        }

        return this.currentLocationInRoom;
    }
}
