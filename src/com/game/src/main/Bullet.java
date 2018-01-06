package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.awt.*;

public class Bullet extends GameObject implements EntityFriendly {

    private Textures textures;
    private Game game;

    public Bullet(double x, double y, Textures textures, Game game) {
        super(x, y);
        this.textures = textures;
        this.game = game;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void tick() {
        x -= 5;
    }

    public void render(Graphics g) {
        g.drawImage(textures.missile, (int) x, (int) y, null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
