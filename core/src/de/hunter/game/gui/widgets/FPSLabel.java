package de.hunter.game.gui.widgets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.utils.TimeUtils;
import de.hunter.game.camera.Camera;
import de.hunter.game.gui.widgets.lib.Label;

public class FPSLabel extends Label {
    long lastTimeCounted;
    private float sinceChange;
    private float frameRate;


    public FPSLabel(Camera camera) {
        super(camera);
        lastTimeCounted = TimeUtils.millis();
        sinceChange = 0;
        frameRate = Gdx.graphics.getFramesPerSecond();
        setColor(Color.RED);
        setText("0 FPS");
    }

    @Override
    public void update() {
        long delta = TimeUtils.timeSinceMillis(lastTimeCounted);
        lastTimeCounted = TimeUtils.millis();

        sinceChange += delta;
        if(sinceChange >= 1000) {
            sinceChange = 0;
            frameRate = Gdx.graphics.getFramesPerSecond();
            setText((int)frameRate+"fps");
        }
    }
}
