package de.hunter.game.gui.widgets.lib;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.hunter.game.camera.Camera;

public class Label extends Widget {
    private Camera camera;
    private final BitmapFont font;
    private String text = "";
    public Label(Camera camera){
        this.camera = camera;
        this.font = new BitmapFont();
        font.getData().setScale(.99f);
    }

    public void setText(String text){
        this.text = text;
    }

    public void setColor(Color color){
        font.setColor(color);
    }

    public void render(SpriteBatch batch){
        if (!isHidden()) font.draw(batch, text, getLocation().getX(), getLocation().getY());
        update();
    }
    /** Updates on Tick/Render. **/
    public void update(){}

    @Override
    public void dispose() {
        font.dispose();
    }
}
