package de.hunter.game.gui.widgets.lib;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import de.hunter.game.gamemath.Location2D;

public class Widget implements IWidget, Disposable {
    private final Location2D location2D = new Location2D();
    private boolean isHidden = false;

    @Override
    public void dispose() {

    }

    @Override
    public Location2D getLocation() {
        return location2D;
    }

    @Override
    public void setLocation(int x, int y) {
        location2D.set(x, y);
    }
    public Location2D getLocation2D() {
        return location2D;
    }
    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void update() {

    }
    public boolean isHidden() {
        return isHidden;
    }
    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
}
