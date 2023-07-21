package de.hunter.game.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import de.hunter.game.GameConst;
import de.hunter.game.gamemath.GameMath;
import de.hunter.game.gui.OverlyText;

/** Handles the Player movement. **/
public class CameraController implements InputProcessor {
    private boolean isMouseCatched = true;
    private final Camera camera;
    private final Vector3 tempV3 = new Vector3();
    private final Vector3 tempV31 = new Vector3();
    private boolean isWPressed = false;
    private boolean isAPressed = false;
    private boolean isSPressed = false;
    private boolean isDPressed = false;
    private boolean isSpacePressed = false;
    private boolean isShiftPressed = false;

    public CameraController(Camera camera){
        this.camera = camera;
    }

    public void setMouseCatched(boolean isCatched){
        this.isMouseCatched = isCatched;
        Gdx.input.setCursorCatched(isCatched);
    }
    public void update(){
        final float dt = Gdx.graphics.getDeltaTime();
        if (isWPressed) camera.translate(tempV3.set(camera.forw).scl(dt * GameConst.SPEED));
        if (isSPressed) camera.translate(tempV3.set(camera.forw).scl(-dt * GameConst.SPEED));
        if (isAPressed) camera.translate(tempV3.set(camera.hor).scl(-dt * GameConst.SPEED));
        if (isDPressed) camera.translate(tempV3.set(camera.hor).scl(dt * GameConst.SPEED));
        if (isShiftPressed) camera.addHeight(-GameConst.SPEED*dt);
        if (isSpacePressed) camera.addHeight(GameConst.SPEED*dt);
        camera.position.y = camera.getHeight(); // overwrite height
        OverlyText.getLabel("PositionLabel").setText("Pos: "+ camera.position);
        OverlyText.getLabel("DirectionLabel").setText("Dir: "+ camera.direction);
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.W){
            isWPressed = true;
        }else if (keycode == Keys.A){
            isAPressed = true;
        }else if (keycode == Keys.S){
            isSPressed = true;
        }else if (keycode == Keys.D){
            isDPressed = true;
        } else if (keycode == Keys.SPACE) {
            isSpacePressed = true;
        } else if (keycode == Keys.SHIFT_LEFT) {
            isShiftPressed = true;
        } else if (keycode == Keys.P){
            camera.direction.y = -0.99f;
            //camera.update();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.W){
            isWPressed = false;
        }else if (keycode == Keys.A){
            isAPressed = false;
        }else if (keycode == Keys.S){
            isSPressed = false;
        }else if (keycode == Keys.D){
            isDPressed = false;
        } else if (keycode == Keys.SPACE) {
            isSpacePressed = false;
        } else if (keycode == Keys.SHIFT_LEFT) {
            isShiftPressed = false;
        } else if (keycode == Keys.Q){
            Gdx.app.exit();
        } else if (keycode == Keys.TAB){
            setMouseCatched(!isMouseCatched);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO to large deltaY "overflows" the y-rotation-ange and the player flips 180 deg in X-direc.
        if (!isMouseCatched) return false;
        Gdx.input.setCursorCatched(true);
        float deltaX = -Gdx.input.getDeltaX() * .5f;
        float deltaY = -Gdx.input.getDeltaY() * .5f;
        if (deltaY == -270) return false; // TODO (<- quick fix) if user clicks in window at first time -> looks straight up
        float camDeg = camera.direction.y*90; // -90 to +90 -> angle
        camera.direction.rotate(camera.up, deltaX); // handle cam turn in X-direction (works fine)
        tempV31.set(camera.direction).crs(camera.up).nor(); // create horizontal vector. Used as axis for rotation.

        OverlyText.getLabel("DeltaY").setText("deltaY: "+deltaY+" | Deg: "+camDeg);

        if (!GameMath.isNeg(deltaY)) { // Look UP (90) -> deltaY positive
            if (camDeg + deltaY > 90.0f) {
                deltaY = 90 - camDeg;
            }
        }
        if (GameMath.isNeg(deltaY)) { // Look down (-90) -> deltaY negative
            if (camDeg + deltaY < -90.0f) {
                deltaY = -90 - camDeg;
            }
        }

        camera.direction.rotate(camera.hor, deltaY); // set cam vec to copied & rotate vec3
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        if (amountY == 1f){
            GameConst.SPEED -= 5;
            GameConst.SPEED = GameConst.SPEED<0 ? 0 : GameConst.SPEED;
        } else if (amountY == -1f){
            GameConst.SPEED += 5;
        }


        return false;
    }
}
