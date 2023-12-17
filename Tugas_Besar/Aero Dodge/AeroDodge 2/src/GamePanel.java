import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    public static JLabel scoreLabel;
    private PlayerPlane playerPlane;
    private enemyPlane EnemyPlane;

    public GamePanel(){
        scoreLabel = new JLabel("Points: 0");
        playerPlane = new PlayerPlane(DodgeGame.WIDTH / 2, DodgeGame.HEIGHT - 50);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.BLACK);
        add(scoreLabel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        playerPlane.draw(g);

        for (enemyPlane enemyCloud : DodgeGame.enemyPlane) {
            enemyCloud.draw(g);
        }

        DodgeGame.coin.draw(g);

        // Display score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Hits: " + DodgeGame.hitCount+ "/5", 10, 24);
    }
    public PlayerPlane getPlayerPlane() {
        return playerPlane;
    }


    public void updateScoreLabel() {
        scoreLabel.setText("Points: " + DodgeGame.score);
    }
}
