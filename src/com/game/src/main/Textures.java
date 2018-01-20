package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures {

    private SpriteSheet ss = null;
    public BufferedImage player, missile, enemy, enemy1, enemy2;

    public Textures(Game game){
        this.ss = new SpriteSheet(game.getSpriteSheet());

        getTextures();

    }

    private void getTextures(){
        player = ss.grabImage(1,1,32,32);
        missile = ss.grabImage(1,4,32,32);
        enemy = ss.grabImage(3,3,32,32);
        enemy1 = ss.grabImage(1,2,32,32);
        enemy2 = ss.grabImage(1,3,32,32);

    }
}
