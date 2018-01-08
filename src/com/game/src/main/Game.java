package com.game.src.main;

import com.game.src.main.com.game.src.main.classes.EntityEnemies;
import com.game.src.main.com.game.src.main.classes.EntityFriendly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static final String TITLE = "2D Dino's Battles";
    public static int HEALTH = 200;

    private boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;
    private BufferedImage menuStart = null;

    private boolean isShooting = false;
    private int enemyCount = 3;
    private int enemyKilled = 0;

    private Player player;
    private Controller controller;
    private Textures textures;
    private Menu menu;

    public LinkedList<EntityFriendly> entityFriendly;
    public LinkedList<EntityEnemies> entityEnemies;

    public static enum STATE{
        MENU, GAME
    };

    public static STATE State = STATE.MENU;

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getEnemyKilled() {
        return enemyKilled;
    }

    public void setEnemyKilled(int enemyKilled) {
        this.enemyKilled = enemyKilled;
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public void init(){
        requestFocus();
        BufferedImageLoader loader = new BufferedImageLoader();

        try {
            background = loader.loadImage("/res/sand.jpg");
            spriteSheet = loader.loadImage("/res/Dino.png");
            menuStart = loader.loadImage("/res/menuStart.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addKeyListener(new KeyInput(this));
        this.addMouseListener(new MouseInput());
        textures = new Textures(this);
        controller = new Controller(this, textures);
        player = new Player(600, 200, textures, this, controller);
        menu = new Menu();
        controller.createEnemy(enemyCount);

        entityFriendly = controller.getEntityFriendly();
        entityEnemies = controller.getEntitiyEnemies();
    }

    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop (){
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (State == STATE.GAME) {
            if (key == KeyEvent.VK_RIGHT) {
                player.setVelX(2);
            } else if (key == KeyEvent.VK_LEFT) {
                player.setVelX(-2);
            } else if (key == KeyEvent.VK_UP) {
                player.setVelY(-2);
            } else if (key == KeyEvent.VK_DOWN) {
                player.setVelY(2);
            } else if (key == KeyEvent.VK_SPACE && !isShooting) {
                isShooting = true;
                controller.addEntity(new Bullet(player.getX(), player.getY(), textures, this, controller));
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (State == STATE.GAME) {
            if (key == KeyEvent.VK_RIGHT) {
                player.setVelX(0);
            } else if (key == KeyEvent.VK_LEFT) {
                player.setVelX(0);
            } else if (key == KeyEvent.VK_UP) {
                player.setVelY(0);
            } else if (key == KeyEvent.VK_DOWN) {
                player.setVelY(0);
            } else if (key == KeyEvent.VK_SPACE) {
                isShooting = false;
            }
        }
    }

    public static void main(String[] args) {

        Game game = new Game();

        game.setPreferredSize (new Dimension (WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize (new Dimension (WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize (new Dimension (WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int uptades = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1){
                tick();
                uptades++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(uptades + " Ticks, Fps " + frames);
                uptades = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick () {
        if (State == STATE.GAME) {
            player.tick();
            controller.tick();

            if (enemyKilled >= enemyCount) {
                enemyCount += 1;
                enemyKilled = 0;
                controller.createEnemy(enemyCount);
            }
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);


        if (State == STATE.GAME) {
            g.drawImage(background,0,0,null);
            player.render(g);
            controller.render(g);

            g.setColor(Color.gray);
            g.fillRect(5,5, 200, 20);

            g.setColor(Color.green);
            g.fillRect(5,5, HEALTH, 20);

            g.setColor(Color.white);
            g.drawRect(5,5, 200, 20);

        } else if (State == STATE.MENU){
            g.drawImage(menuStart,0,0,null);
            menu.render(g);
        }
        g.dispose();
        bs.show();
        return;
    }
}
