package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.awt.*;

public class Bullet extends GameObject implements EntityFriendly {

    private Textures textures;
    private Game game;
    private Controller controller;

    public Bullet(double x, double y, Textures textures, Game game, Controller controller) {
        super(x, y);
        this.textures = textures;
        this.game = game;
        this.controller = controller;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 10);
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
