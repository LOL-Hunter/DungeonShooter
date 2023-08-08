package de.hunter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import de.hunter.game.camera.Camera;

public class Player {
    private boolean isPlayerFlying = true;
    private final Camera camera;
    private final FitViewport viewport;
    private final Main gameInstance;

    public Player(Main main){
        camera = new Camera(75, this);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gameInstance = main;
    }

    public Camera getCamera() {
        return camera;
    }
    public FitViewport getViewport() {
        return viewport;
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
