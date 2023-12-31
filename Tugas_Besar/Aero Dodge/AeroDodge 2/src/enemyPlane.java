import java.util.Random;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class enemyPlane implements gameObject {
    private int x, y;
    private int speed;
    private boolean hit;
    private Image cloudImage;
    private static final Random random = new Random();

    public enemyPlane() {
        this.x = random.nextInt(DodgeGame.WIDTH - 80);
        this.y = random.nextInt(DodgeGame.HEIGHT / 2) - DodgeGame.HEIGHT;
        this.speed = 3;
        this.hit = false;

        // Generate a random number to determine the ship image
        int shipNumber = random.nextInt(3) + 1;
        String imagePath = "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\AeroDodge\\assets\\Ships\\ship_000" + shipNumber + ".png";
        // String imagePath = "/Users/muh.restualizaakbar/Devlop/Java/AeroDodge/assets/Clouds/cloud" + shipNumber + ".png";

        ImageIcon iconCloud = new ImageIcon(imagePath);
        cloudImage = iconCloud.getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT);
    }

    public void resetPosition() {
        // Set the initial position of the player plane
        this.x = random.nextInt(DodgeGame.WIDTH - 80);
        this.y =  random.nextInt(DodgeGame.HEIGHT / 2) - DodgeGame.HEIGHT; // Adjust as needed
        this.speed = 3;
    }

    public void draw(Graphics g) {
        if (!hit) {
            g.drawImage(cloudImage, x, y, null);
        }
    }

    public void update(int speed) {
        y += speed;
        if (y > DodgeGame.HEIGHT || x > DodgeGame.WIDTH) {
            y = -90;
            x = random.nextInt(DodgeGame.WIDTH - 80);
            hit = false; // Reset hit status when the car goes off the scree
        }
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}