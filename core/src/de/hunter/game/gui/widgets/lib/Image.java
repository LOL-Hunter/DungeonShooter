package de.hunter.game.gui.widgets.lib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Image extends Widget{
    private final Texture image;

    public Image(String path){
        this(new Texture(path));
    }
    public Image(Texture texture){
        this.image = texture;
    }

    @Override
    public void dispose() {
        image.dispose();
    }

    public int getWidth(){
        return image.getWidth();
    }
    public int getHeight(){
        return image.getHeight();
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!isHidden()) batch.draw(image, getLocation().getX(), getLocation().getY());
        update();
    }
}