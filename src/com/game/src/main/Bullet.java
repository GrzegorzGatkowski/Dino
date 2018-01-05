package com.game.src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {

    private double x;
    private double y;
    private Textures tex;

    public Bullet(double x, double y, Textures tex) {
        this.x = x;
        this.y = y;
        this.tex = tex;

    }

    public void tick (){
        x -= 5;
    }

    public void render (Graphics g){
        g.drawImage(tex.missile, (int)x, (int)y, null);
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
}
