package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Controller {

    private LinkedList<EntityFriendly> entityFriendly = new LinkedList<>();
    private LinkedList<EntityEnemies> entitiyEnemies = new LinkedList<>();

    Textures textures;
    EntityFriendly eFriendly;
    EntityEnemies eEnemies;
    Game game;
    Random random = new Random ();

    public Controller(Game game, Textures textures) {
        this.game = game;
        this.textures = textures;
    }

    public void tick() {
        for (int i = 0; i < entityFriendly.size(); i++) {
            eFriendly = entityFriendly.get(i);
            eFriendly.tick();
        }
        for (int i = 0; i < entitiyEnemies.size(); i++) {
            eEnemies = entitiyEnemies.get(i);
            eEnemies.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < entityFriendly.size(); i++) {
            eFriendly = entityFriendly.get(i);
            eFriendly.render(g);
        }
        for (int i = 0; i < entitiyEnemies.size(); i++) {
            eEnemies = entitiyEnemies.get(i);
            eEnemies.render(g);
        }
    }

    public void addEntity(EntityFriendly eFriendly){
       entityFriendly.add(eFriendly);
    }
    public void removeEntity(EntityFriendly eFriendly){
       entityFriendly.remove(eFriendly);
    }
    public void addEntity(EntityEnemies eEnemies){
        entitiyEnemies.add(eEnemies);
    }
    public void removeEntity(EntityEnemies eEnemies){
        entitiyEnemies.remove(eEnemies);
    }

    public void createEnemy (int enemyCount){
        for (int i = 0; i < enemyCount; i++){
          addEntity(new Enemy(0, random.nextInt(Game.HEIGHT * Game.SCALE), textures, this, game));
        }
    }

    public LinkedList<EntityFriendly> getEntityFriendly() {
        return entityFriendly;
    }

    public LinkedList<EntityEnemies> getEntitiyEnemies() {
        return entitiyEnemies;
    }
}
