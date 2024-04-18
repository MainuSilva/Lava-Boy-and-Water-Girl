package org.example.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position (Position pos){
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public Position(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() { return new Position(x, y - 1);}

    public Position getDown() { return new Position(x, y + 1);}

    public int getX() { return x;}
    public int getY() {return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


