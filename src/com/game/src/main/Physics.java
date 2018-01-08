package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

public class Physics {

    public static boolean collision (EntityFriendly eFriendly,EntityEnemies eEnemies){

            if (eFriendly.getBounds().intersects(eEnemies.getBounds())){
                return true;
        }
        return false;
    }

    public static boolean collision (EntityEnemies eEnemies, EntityFriendly eFriendly){

            if (eEnemies.getBounds().intersects(eFriendly.getBounds())){
                return true;
        }
        return false;
    }
}
