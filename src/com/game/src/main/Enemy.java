package com.game.src.main;

import java.awt.*;

public class Enemy {

    private double x;
    private double y;

    private Textures tex;

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

    public Enemy(double x, double y, Textures tex) {
        this.x = x;
        this.y = y;
        this.tex = tex;
    }

    public void tick(){
        x += 2;
    }

    public void render (Graphics g){
        g.drawImage(tex.enemy, (int)x, (int)y, null);

    }
}
