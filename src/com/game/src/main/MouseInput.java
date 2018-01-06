package com.game.src.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if (mx >= 50 && mx <= 200){
            if (my >= 80 && my <= 130){
                Game.State = Game.STATE.GAME;
            }
        }
        if (mx >= 50 && mx <= 200){
            if (my >= 200 && my <= 250){
                System.exit(1);
            }
        }
        //public Rectangle playButton = new Rectangle(50, 80, 150, 50);
        //public Rectangle scoresButton = new Rectangle(50, 140, 150, 50);
        //public Rectangle quitButton = new Rectangle(50, 200, 150, 50);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
