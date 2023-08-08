package de.hunter.game.gamemath;

public class Location3D extends BaseLocation{
    protected float z;

    public Location3D(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Location3D(){
        this(0, 0, 0);
    }
    public Location3D(Location3D loc){
        this(loc.getX(), loc.getY(), loc.getZ());
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void set(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Location3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
