package de.hunter.game.gamemath;

public class Rectangle3D {
    private final Location3D location3D = new Location3D();
    private float width, height, depth;
    public Rectangle3D(){
        location3D.set(0, 0, 0);
        this.width = 0;
        this.height = 0;
        this.depth = 0;
    }
    public Rectangle3D(float x, float y, float z, float width, float height, float depth){
        location3D.set(x, y, z);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public Location3D getLocation3D() {
        return location3D;
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public void setDepth(float depth) {
        this.depth = depth;
    }
    public float getDepth() {
        return depth;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public void set(float x, float y, float z, float width, float height, float depth){
        location3D.set(x, y, z);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public void setFromCenter(float x, float y, float z, float width, float height, float depth){
        location3D.set(x - width/2
                , y - height/2
                , z - depth/2
        );
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public boolean collisionWithPoint(Location3D location3D){
        return this.collisionWithPoint(location3D.x, location3D.y, location3D.z);
    }
    public boolean collisionWithPoint(float x, float y, float z){


        return false;
    }
    public boolean collisionWithRectangle(Rectangle3D rectangle3D){


        return false;
    }

    @Override
    public String toString() {
        return "Rectangle3D{" +
                "location3D=" + location3D +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
