package com.yoti.springcleaning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Coordinate {
    private int x, y;

    public void translateByDisplacementCoordinate(Coordinate coordinate){
        this.x += coordinate.getX();
        this.y += coordinate.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
