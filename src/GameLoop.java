import javax.swing.JOptionPane;

public class GameLoop implements Runnable {
    private boolean isRunning = true;
    private static int baseEnemySpeed = 3;
    private PlayerPlane playerPlane;
    private GamePanel gamePanel;

    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.playerPlane = gamePanel.getPlayerPlane();
    }
    
    @Override
    public void run() {
        while (isRunning) {
            playerPlane.update();
    
            for (enemyPlane enemyCloud : DodgeGame.enemyCloud) {
                enemyCloud.update(baseEnemySpeed);
                if (playerPlane.intersects(enemyCloud)) {
                    gameOver();
                }
            }
    
            gamePanel.repaint();
    
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(gamePanel, "Game Over! Your score: " + DodgeGame.score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}