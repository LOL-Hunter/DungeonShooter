package de.hunter.game.gamemath;

import com.badlogic.gdx.Gdx;

public class GameMath {

    public static boolean isNeg(float f){
        return f < 0;
    }
    public static int getScCenX(){
        return Gdx.graphics.getWidth()/2;
    }
    public static int getScCenY(){
        return Gdx.graphics.getHeight()/2;
    }





}
