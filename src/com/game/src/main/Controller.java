package com.game.src.main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<Bullet> b = new LinkedList<>();
    private LinkedList<Enemy> e = new LinkedList<>();

    Bullet tempBullet;
    Enemy tempEnemy;
    Textures tex;
    Game game;
    Random r = new Random();

    public Controller(Game game, Textures tex) {
        this.game = game;
        this.tex = tex;

        addEnemy(new Enemy(0, r.nextInt(Game.HEIGHT * Game.SCALE), tex));
    }

    public void tick (){
        for (int i = 0; i < b.size(); i++){
            tempBullet = b.get(i);

            if(tempBullet.getX() < 0)
                removeBullet(tempBullet);

            tempBullet.tick();
        }
        for (int i = 0; i < e.size(); i++){
            tempEnemy = e.get(i);

            tempEnemy.tick();
        }

    }

    public void render (Graphics g){
        for (int i = 0; i < b.size(); i++){
            tempBullet = b.get(i);

            tempBullet.render(g);
        }
        for (int i = 0; i < e.size(); i++){
            tempEnemy = e.get(i);

            tempEnemy.render(g);
        }
    }

    public void addBullet (Bullet block){
        b.add(block);
    }

    public void removeBullet (Bullet block){
        b.remove(block);
    }

    public void addEnemy (Enemy block){
        e.add(block);
    }

    public void removeEnemy (Enemy block){
        e.remove(block);
    }
}
