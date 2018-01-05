package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private double x;
    private double y;

    private double velX;
    private double velY;

    private Textures tex;

    public Player (double x, double y, Textures tex){
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    public void tick (){
        x += velX;
        y += velY;

        if (x <= (Game.WIDTH * Game.SCALE)-64)
            x = (Game.WIDTH * Game.SCALE)-64;
        if (x >= (Game.WIDTH * Game.SCALE)-32)
            x = ((Game.WIDTH * Game.SCALE)-32);

        if (y <= 0)
            y = 0;
        if (y >= (Game.HEIGHT * Game.SCALE)-32)
            y = ((Game.HEIGHT * Game.SCALE)-32);

    }

    public void render (Graphics g){
        g.drawImage(tex.player, (int)x, (int)y, null);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }
}
