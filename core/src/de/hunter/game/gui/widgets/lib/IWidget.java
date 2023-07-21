package de.hunter.game.gui.widgets.lib;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.hunter.game.gamemath.Location2D;

public interface IWidget {
    Location2D getLocation();
    void setLocation(int x, int y);
    void render(SpriteBatch batch);
    void resize(int width, int height);
    void update();



}
