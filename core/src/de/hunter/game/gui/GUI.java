package de.hunter.game.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.OrderedMap;
import de.hunter.game.camera.Camera;
import de.hunter.game.gamemath.GameMath;
import de.hunter.game.gui.widgets.lib.Image;
import de.hunter.game.gui.widgets.lib.Widget;

public class GUI {
    public static SpriteBatch batch;
    public static OrderedMap<String, Widget> widgets = new OrderedMap<>();

    public static void init(Camera camera){
        batch = new SpriteBatch();
        registerWidget("Crosshair", new Image("crosshair.png"));

        Image crosshair = (Image) getWidget("Crosshair");
        crosshair.setLocation(GameMath.getScCenX()-crosshair.getWidth()/2, GameMath.getScCenY()-crosshair.getHeight()/2);
    }
    public static Widget getWidget(String name){
        return widgets.get(name);
    }
    public static void registerWidget(String name, Widget widget){
        widgets.put(name, widget);
    }
    public static void render(){
        batch.begin();
        for (Widget l:widgets.values()){
            l.render(batch);
        }
        batch.end();
    }
    public static void dispose() {
        for (Widget l:widgets.values()){
            l.dispose();
        }
    }
    public static void resize(int width, int height) {
        for (Widget l:widgets.values()){
            l.resize(width, height);
        }
    }





}
