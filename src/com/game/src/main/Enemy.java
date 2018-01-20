package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements EntityEnemies {

    public static double velX = 2;
    private Random random = new Random ();
    private Textures textures;
    private Game game;
    private Controller controller;

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Enemy(double x, double y, Textures textures, Controller controller, Game game) {
        super(x, y);
        this.textures = textures;
        this.controller = controller;
        this.game = game;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void tick(){
        x += velX;

        if (x > Game.WIDTH * Game.SCALE){
            y = (random.nextInt(Game.HEIGHT * Game.SCALE)+50)*0.8;
            x = 0;
            game.setScores(game.getScores() - 2);
            Game.HEALTH -= 5;
            if (game.getScores() < 0)
                game.setScores(0);
        }

        for (int i = 0; i < game.entityFriendly.size(); i++){
            EntityFriendly tempFriend = game.entityFriendly.get(i);
                if (Physics.collision(this, tempFriend)){
                    controller.removeEntity(tempFriend);
                    controller.removeEntity(this);
                    game.setEnemyKilled(game.getEnemyKilled() + 1);
                    game.setScores(game.getScores() + 5);
                    game.setAllKilled(game.getAllKilled() + 1);
            }
        }


    }

    public void render (Graphics g){
        g.drawImage(textures.enemy, (int)x, (int)y, null);

    }
}
