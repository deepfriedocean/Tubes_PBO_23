import javax.swing.JOptionPane;

public class GameLoop implements Runnable {
    private boolean isRunning = true;
    public static int baseEnemySpeed = 3;
    // private int enemySpeed = baseEnemySpeed;
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

            if (playerPlane.intersects(DodgeGame.coin)) {
                //Score
                DodgeGame.score += 2;
                DodgeGame.coin.collect();
                gamePanel.updateScoreLabel();
                updateEnemySpeed();
            }

            if (DodgeGame.coin.isCollected()) {
                DodgeGame.coin.resetPosition();
            }
    
            gamePanel.repaint();
    
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateEnemySpeed() {
        if (DodgeGame.score % 10 == 0) {
            baseEnemySpeed += 1;
        }
        System.out.println(baseEnemySpeed);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(gamePanel, "Game Over! Your score: " + DodgeGame.score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}