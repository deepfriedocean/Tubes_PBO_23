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
        int shipNumber = random.nextInt(2) + 1;
        String imagePath = "/Users/muh.restualizaakbar/Devlop/Java/AeroDodge/assets/Ships/ship_000" + shipNumber + ".png";
        // String imagePath = "/Users/muh.restualizaakbar/Devlop/Java/AeroDodge/assets/Clouds/cloud" + shipNumber + ".png";

        ImageIcon iconCloud = new ImageIcon(imagePath);
        cloudImage = iconCloud.getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT);
    }

    public void draw(Graphics g) {
        // g.setColor(Color.RED);
        // g.fillRect(x, y, 50, 30);
        if (!hit) {
            g.drawImage(cloudImage, x, y, null);
        }
    }

    public void update(int speed) {
        y += speed;
        if (y > DodgeGame.HEIGHT || x > DodgeGame.WIDTH) {
            y = -90;
            x = random.nextInt(DodgeGame.WIDTH - 80);
            hit = false;
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