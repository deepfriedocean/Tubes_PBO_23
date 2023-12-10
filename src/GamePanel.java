import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private JLabel scoreLabel;
    private PlayerPlane playerPlane;

    public GamePanel(){
        scoreLabel = new JLabel("Points: 0");
        playerPlane = new PlayerPlane(DodgeGame.WIDTH / 2, DodgeGame.HEIGHT - 50);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.BLACK);
        add(scoreLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        playerPlane.draw(g);

        for (enemyPlane enemyCloud : DodgeGame.enemyCloud) {
            enemyCloud.draw(g);
        }

    }
    public PlayerPlane getPlayerPlane() {
        return playerPlane;
    }

    public void updateScoreLabel() {
        scoreLabel.setText("Points: " + DodgeGame.score);
    }
}
