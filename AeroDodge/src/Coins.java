import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Coins implements gameObject, Runnable {
    private int x, y;
    private boolean collected;
    private static final Random random = new Random();
    private Image coinImage;
    private Thread coinThread;

    public Coins() {
        resetPosition();
        collected = false;
        ImageIcon coinIcon = new ImageIcon("C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\AeroDodge\\assets\\Tiles\\tile_0025.png");
        coinImage = coinIcon.getImage().getScaledInstance(30, 40, Image.SCALE_DEFAULT);

        coinThread = new Thread(this);
        coinThread.start();
    }

    
    public void run() {
        // The main loop for the thread
        while (!Thread.interrupted()) {
            DodgeGame.coin.update(GameLoop.baseEnemySpeed);
            try {
                Thread.sleep(8); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void resetPosition() {
        collected = false;
        x = random.nextInt(DodgeGame.WIDTH - 30);
        y = random.nextInt(DodgeGame.HEIGHT / 2) - DodgeGame.HEIGHT;
    }

    // public void draw(Graphics g) {
    //     if (!collected) {
    //         g.drawImage(coinImage, x, y, null);
    //     }
    // }
    public void draw(Graphics g) {
        if (!collected) {
            g.drawImage(coinImage, x, y, null);
        } else {
            resetPosition(); // Move the collected coin off-screen
        }
    }

    public void collect() {
        collected = true;
        resetPosition(); // Move the collected coin off-screen
    }

    public boolean isCollected() {
        return collected;
    }

    public void update(int speed) {
        y += speed;
        if (y > DodgeGame.HEIGHT) {
            resetPosition(); // Reset the coin position if it goes off the screen
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
