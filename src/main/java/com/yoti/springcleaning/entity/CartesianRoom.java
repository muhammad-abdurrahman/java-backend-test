package com.yoti.springcleaning.entity;

import lombok.Getter;
import java.util.HashSet;

public class CartesianRoom {

    @Getter private final int xMax, yMax;
    private final HashSet<Coordinate> dirtPatchCoords;

    public CartesianRoom(int xMax, int yMax, HashSet<Coordinate> dirtPatchCoords){
        this.xMax = xMax;
        this.yMax = yMax;
        this.dirtPatchCoords = dirtPatchCoords;
    }

    public boolean removeDirtyPatch(Coordinate coordinate){
        return this.dirtPatchCoords.remove(coordinate);
    }

    public boolean isCoordinateDirty(Coordinate coordinate){
        return this.dirtPatchCoords.contains(coordinate);
    }
}
