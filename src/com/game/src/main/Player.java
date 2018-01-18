package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.awt.*;

public class Player extends GameObject implements EntityFriendly {

    private double velX;
    private double velY;

    Controller controller;
    Game game;
    private Textures textures;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public Player (double x, double y, Textures textures, Game game, Controller controller){
        super(x, y);
        this.textures = textures;
        this.game = game;
        this.controller = controller;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
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

        for (int i = 0; i < game.entityEnemies.size(); i++){
            EntityEnemies enemyTemp = game.entityEnemies.get(i);

            if (Physics.collision(this, enemyTemp)){
                controller.removeEntity(enemyTemp);
                Game.HEALTH -= 20;
                game.setEnemyKilled(game.getEnemyKilled() + 1);
            }
        }

    }

    public void render (Graphics g){
        g.drawImage(textures.player, (int)x, (int)y, null);

    }
}
