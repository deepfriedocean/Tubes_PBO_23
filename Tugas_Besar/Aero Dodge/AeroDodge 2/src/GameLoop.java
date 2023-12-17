import javax.swing.JOptionPane;
import Database.DatabaseManager;

public class GameLoop implements Runnable {
    private boolean isRunning = true;
    private String username;
    public static int baseEnemySpeed = 3;
    private PlayerPlane playerPlane;
    private GamePanel gamePanel;

    public GameLoop(GamePanel gamePanel, String username) {
        this.username = username;
        this.gamePanel = gamePanel;
        this.playerPlane = gamePanel.getPlayerPlane();
    }
    
    @Override
    public void run() {
        while (isRunning) {
            playerPlane.update();
    
            for (enemyPlane enemyCloud : DodgeGame.enemyPlane) {
                enemyCloud.update(baseEnemySpeed);
                if (playerPlane.intersects(enemyCloud)) {
                    handleCollision(enemyCloud);
                }
            }

            if (playerPlane.intersects(DodgeGame.coin)) {
                //Score
                DodgeGame.setScore(DodgeGame.score + 2);
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

    private void handleCollision(enemyPlane enemyPlane) {
        if (!enemyPlane.isHit()) {
            enemyPlane.setHit(true);
            DodgeGame.hitCount++;
            if (DodgeGame.hitCount == 5) {
                DodgeGame.gameOverSound.play();

                gameOver();
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
        int choice = JOptionPane.showOptionDialog(
                gamePanel, // Use the gamePanel as the parent component
                "Game Over! Your score: " + DodgeGame.score,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Restart", "Exit"},
                "Restart");
    
        if (choice == JOptionPane.YES_OPTION) {
            // DodgeGame dg = new DodgeGame(username);
            resetGameState();
        } else {
            DatabaseManager dodgeDb = new DatabaseManager();
            int userId = dodgeDb.fetchUserId(username);
            // Assuming DodgeGame.score is the actual score to be inserted
            dodgeDb.insertScore(userId, DodgeGame.score);
            System.exit(0);
        }
    }
    public void resetGameState() {
        DodgeGame.setScore(0);
        DodgeGame.hitCount = 0;
        GameLoop.baseEnemySpeed = 3;
        gamePanel.updateScoreLabel();
        gamePanel.getPlayerPlane().resetPosition();

        for (enemyPlane EnemyPlane : DodgeGame.enemyPlane) {
            EnemyPlane.resetPosition();
        }
    }
}