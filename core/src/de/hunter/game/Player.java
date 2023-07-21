package de.hunter.game;

import de.hunter.game.camera.Camera;

public class Player {
    private boolean isPlayerFlying = true;
    private final Camera camera;
    private final Main gameInstance;

    public Player(Main main){
        camera = new Camera(75, this);
        gameInstance = main;
    }

    public Camera getCamera() {
        return camera;
    }

    public void update() {
        camera.update();
    }
    public float getFov(){
        return camera.fieldOfView;
    }
    public void setFov(float fieldOfView){
        camera.fieldOfView = fieldOfView;
    }

    public boolean isPlayerFlying() {
        return isPlayerFlying;
    }

    public void setPlayerFlying(boolean playerFlying) {
        isPlayerFlying = playerFlying;
    }
}
