import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;  // Import the List interface from java.util
import Music.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DodgeGame extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 700;
    private GamePanel gamePanel;
    public static List<enemyPlane> enemyPlane;  // Use the List interface from java.util
    public static int score;
    public static int hitCount; 
    public static Coins coin;
    public String Username;
    public static BackgroundMusic backgroundMusic = new BackgroundMusic("C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\music\\background.wav");
    public static CoinSound coinSound;
    public static GameOverSound gameOverSound;
    private JFrame gameFrame;


    public DodgeGame(String username) {
        setTitle("Aero Dodge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setScore(0);
        hitCount = 0;
        coin = new Coins();
        Username = username;
        

        gamePanel = new GamePanel();
        enemyPlane = Collections.synchronizedList(new ArrayList<>());
        add(gamePanel);

        coinSound = new CoinSound("C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\music\\point.wav");
        gameOverSound = new GameOverSound("C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\music\\gameover.wav");

        for (int i = 0; i < 5; i++) {
            enemyPlane.add(new enemyPlane());
        }

        setLocationRelativeTo(null);
        setResizable(false);
        gamePanel.setBackground(new Color(224, 244, 244));
        setVisible(true);

        PlayerInput playerInput = new PlayerInput(gamePanel.getPlayerPlane());
        addKeyListener(playerInput);

        new Thread(new GameLoop(gamePanel, Username)).start();
    }
    public static BackgroundMusic getBackgroundMusic() {
        return backgroundMusic;
    }
    public static void setScore(int newScore) {
        score = newScore;
    }
    public static int getScore() {
        return score;
    }

    public JFrame getGameFrame() {
        return gameFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DodgeGame(""));
    }
}