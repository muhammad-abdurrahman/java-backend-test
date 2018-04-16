package com.yoti.springcleaning.entity;

import lombok.Getter;
import java.util.HashSet;

public class Room {

    @Getter private final Coordinate maxCoords;
    private final HashSet<Coordinate> dirtPatchCoords;

    public Room(Coordinate maxCoords, HashSet<Coordinate> dirtPatchCoords){
        this.maxCoords = maxCoords;
        this.dirtPatchCoords = dirtPatchCoords;
    }

    public boolean removeDirtyPatch(Coordinate coordinate){
        return this.dirtPatchCoords.remove(coordinate);
    }

    public boolean isCoordinateDirty(Coordinate coordinate){
        return this.dirtPatchCoords.contains(coordinate);
    }
}
