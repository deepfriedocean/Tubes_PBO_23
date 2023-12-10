import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DodgeGame extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 700;
    private GamePanel gamePanel;
    public static List<enemyPlane> enemyCloud; 
    public static int score;
    public static int hitCount; 
    public static Coins coin;


    public DodgeGame() {
        setTitle("AeroDodge Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        score = 0;
        hitCount = 0;
        coin = new Coins();

        gamePanel = new GamePanel();
        enemyCloud = Collections.synchronizedList(new ArrayList<>());
        add(gamePanel);

        for (int i = 0; i < 5; i++) {
            enemyCloud.add(new enemyPlane());
        }

        setLocationRelativeTo(null);
        setResizable(false);
        gamePanel.setBackground(new Color(224, 244, 244));
        setVisible(true);

        PlayerInput playerInput = new PlayerInput(gamePanel.getPlayerPlane());
        addKeyListener(playerInput);

        new Thread(new GameLoop(gamePanel)).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DodgeGame());
    }
}