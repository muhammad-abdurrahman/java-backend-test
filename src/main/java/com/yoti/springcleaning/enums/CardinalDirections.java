package com.yoti.springcleaning.enums;

import com.yoti.springcleaning.entity.Coordinate;

public enum CardinalDirections {
    N(new Coordinate(0,1)),
    S(new Coordinate(0, -1)),
    E(new Coordinate(1, 0)),
    W(new Coordinate(-1, 0));

    private Coordinate coordinate;

    CardinalDirections(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getDisplacementCoordinates(){
        return this.coordinate;
    }
}
