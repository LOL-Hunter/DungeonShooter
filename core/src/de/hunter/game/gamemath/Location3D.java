package de.hunter.game.gamemath;

public class Location3D extends BaseLocation{
    protected int z;

    public Location3D(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Location3D(){
        this(0, 0);
    }
    public Location3D(Location2D loc){
        this(loc.getX(), loc.getY());
    }
    public void setZ(int z) {
        this.z = z;
    }
    public void set(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getZ() {
        return z;
    }
}
