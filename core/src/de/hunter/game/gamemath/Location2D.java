package de.hunter.game.gamemath;

public class Location2D extends BaseLocation{



    public Location2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Location2D(){
        this(0, 0);
    }
    public Location2D(Location2D loc){
        this(loc.getX(), loc.getY());
    }
    public void set(int x, int y){


    }
}