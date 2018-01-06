package com.game.src.main;

import java.awt.*;

public class Menu {

    public Rectangle playButton = new Rectangle(50, 80, 150, 50);
    public Rectangle scoresButton = new Rectangle(50, 140, 150, 50);
    public Rectangle quitButton = new Rectangle(50, 200, 150, 50);

    public void render (Graphics g){

        Graphics2D graphics2D = (Graphics2D) g;
        Font font1 = new Font("arial", Font.BOLD, 50);

        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("DINO'S BATTLES", Game.WIDTH / 2, 50);

        Font font2 = new Font("arial", Font.BOLD, 30);
        g.setFont(font2);
        g.drawString("PLAY", playButton.x + 35, playButton.y + 35);
        g.drawString("SCORES", scoresButton.x + 15, scoresButton.y + 35);
        g.drawString("QUIT", quitButton.x + 35, quitButton.y + 35);
        graphics2D.draw(playButton);
        graphics2D.draw(scoresButton);
        graphics2D.draw(quitButton);
    }
}
