package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures {

    private SpriteSheet ss = null;
    public BufferedImage player, missile, enemy;

    public Textures(Game game){
        this.ss = new SpriteSheet(game.getSpriteSheet());

        getTextures();

    }

    private void getTextures(){
        player = ss.grabImage(1,1,32,32);
        missile = ss.grabImage(2,1,32,32);
        enemy = ss.grabImage(1,2,32,32);

    }
}
