package de.hunter.game.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import de.hunter.game.Player;

/**
 * Camera. Represents Player.
 * Movement is handled here.
 */
public class Camera extends PerspectiveCamera {
    private final CameraController cameraController;
    private float height = 0.0f;
    public final Vector3 hor = new Vector3();
    public final Vector3 forw = new Vector3();
    private final Player player;
    public Camera(int fieldOfView, Player player) {
        super(fieldOfView, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.player = player;
        this.position.set(-10, 0, 0); // set Camera Position
        this.lookAt(10, 0, 0); // Look at Coordinate
        this.near = 1f;              // near (range camera) "render distance"
        this.far = 100f;             // far
        this.update();
        //addHeight(20);
        cameraController = new CameraController(this);
        Gdx.input.setInputProcessor(cameraController);
        System.out.print(forw);
    }

    public float getHeight() {
        return height;
    }
    public void addHeight(float height){
        this.height += height;
    }

    public void setRenderDistance(float min, float max) {
        this.near = min;
        this.far = max;
    }
    public float getCameraRotation() {
        return -(float) Math.atan2(up.x, up.y)* MathUtils.radiansToDegrees + 180;
    }

    @Override
    public void update() {
        super.update();
        if (cameraController == null) return;
        cameraController.update();
        hor.set(this.direction).crs(this.up).nor(); // horizontal Vector vor look down & move sideways
        forw.set(this.direction.x, 0, this.direction.z).nor(); // Sight Vector without y component.
    }

    public CameraController getController() {
        return cameraController;
    }

    public Player getPlayer() {
        return player;
    }
}