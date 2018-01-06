package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import java.util.LinkedList;

public class Physics {

    public static boolean collision (EntityFriendly eFriendly, LinkedList<EntityEnemies> entityEnemies){

        for (int i = 0; i < entityEnemies.size(); i++){
            if (eFriendly.getBounds().intersects(entityEnemies.get(i).getBounds())){
                return true;
            }
        }
        return false;
    }

    public static boolean collision (EntityEnemies eEnemies, LinkedList<EntityFriendly> entityFriendly){

        for (int i = 0; i < entityFriendly.size(); i++){
            if (eEnemies.getBounds().intersects(entityFriendly.get(i).getBounds())){
                return true;
            }
        }
        return false;
    }
}
