import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PlayerPlane {
        private int x, y;
        private int speed;
        private boolean leftPressed, rightPressed;
        private Image playerImage;


        public PlayerPlane(int x, int y) {
            this.x = x;
            this.y = y;
            this.speed = 10;
            ImageIcon icon = new ImageIcon("C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\AeroDodge\\assets\\Ships\\ship_0000.png");
            playerImage = icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        }
        
        public void resetPosition() {
            // Set the initial position of the player plane
            this.x = DodgeGame.WIDTH / 2;
            this.y = DodgeGame.HEIGHT - 50; // Adjust as needed
        }

        public void draw(Graphics g) {
            g.drawImage(playerImage, x, y - 40, null);
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = false;
            }
        }

        public void update() {
            if (leftPressed && x > 0) {
                x -= speed;
            }
            if (rightPressed && x < DodgeGame.WIDTH - 80) {
                x += speed;
            }
        }
        
        public boolean intersects(gameObject GameObject) {
            Rectangle playerRect = new Rectangle(x, y - 30, 50, 30);
            Rectangle objectRect = new Rectangle(GameObject.getX(), GameObject.getY(), 50, 30);
            return playerRect.intersects(objectRect);
        }
    }