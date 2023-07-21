package de.hunter.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.OrderedMap;
import de.hunter.game.camera.Camera;
import de.hunter.game.gui.widgets.DeltaY;
import de.hunter.game.gui.widgets.DirectionLabel;
import de.hunter.game.gui.widgets.FPSLabel;
import de.hunter.game.gui.widgets.PositionLabel;
import de.hunter.game.gui.widgets.lib.Label;

public class OverlyText {
    public static SpriteBatch batch;
    public static OrderedMap<String, Label> labels = new OrderedMap<>();

    public static void init(Camera camera){
        batch = new SpriteBatch();
        labels.put("FPSLabel", new FPSLabel(camera));
        labels.put("PositionLabel", new PositionLabel(camera));
        labels.put("DirectionLabel", new DirectionLabel(camera));
        labels.put("DeltaY", new DeltaY(camera));


        int i=0;
        for (Label l:labels.values()){
            l.setLocation(3, Gdx.graphics.getHeight() - (15*i));
            i++;
        }
    }
    public static Label getLabel(String name){
        return labels.get(name);
    }

    public static void render(){
        batch.begin();
        for (Label l:labels.values()){
            l.render(batch);
        }
        batch.end();
    }

    public static void dispose() {
        for (Label l:labels.values()){
            l.dispose();
        }
    }

    public static void resize(int width, int height) {
        for (Label l:labels.values()){
            l.resize(width, height);
        }
    }
}
