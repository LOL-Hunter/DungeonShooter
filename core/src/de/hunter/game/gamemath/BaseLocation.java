package de.hunter.game.gamemath;

public class BaseLocation {
    protected float x;
    protected float y;

    public float getX(){
        return this.x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "BaseLocation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
