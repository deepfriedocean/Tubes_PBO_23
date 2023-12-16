package Zhafran.Pages;

import javax.swing.*;
import java.awt.*;;

public class LeaderboardPage {
    private static JFrame leaderBoardFrame;
    private static JPanel mainPanel, leaderBoardPanel, buttonPanel;
    private static JLabel profileTitle;
    private static JButton goBack;

    public static void main(String[] args) {

        // Main Leaderboard frame
        leaderBoardFrame = new JFrame("Leaderboard");
        leaderBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Leaderboard Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#D2EAEE"));

        // Create a scroll pane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Leaderboard Title Panel
        leaderBoardPanel = new JPanel(new BorderLayout());
        leaderBoardPanel.setBackground(Color.decode("#A5C1D0"));

        // Buttons Panel
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.decode("#8AC1E0"));
        Dimension buttonPanelSize = new Dimension(380, 50);
        buttonPanel.setPreferredSize(buttonPanelSize);

        // Leaderboard Title Components
        profileTitle = new JLabel("Leaderboard");
        profileTitle.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        profileTitle.setHorizontalAlignment(SwingConstants.CENTER);
        profileTitle.setVerticalAlignment(SwingConstants.CENTER);
        leaderBoardPanel.add(profileTitle);

        // Player Data
        String[] players = {"Liam", "Noel", "Bonehead", "Guigsy", "Alan"};
        int[] highScores = {20, 30, 10, 25, 15};

        // Loop through players and highScores to create panels
        for (int i = 0; i < players.length; i++) {
            JPanel playerPanel = new JPanel();
            playerPanel.setBackground(Color.decode("#E8F3F9"));
            Dimension playerPanelSize = new Dimension(380, 75);
            playerPanel.setPreferredSize(playerPanelSize);

            JLabel playerInfoLabel = new JLabel("Name: " + players[i] + " | High Score: " + highScores[i]);
            playerInfoLabel.setFont(new Font("Cambria", Font.BOLD, 16));
            playerPanel.add(playerInfoLabel);

            mainPanel.add(playerPanel);
        }

        // Buttons
        goBack = new JButton("Go Back");
        goBack.setBackground(Color.decode("#7DCAA5"));
        goBack.setForeground(Color.WHITE);
        buttonPanel.add(goBack);

        // Add components to the frame
        leaderBoardFrame.add(leaderBoardPanel, BorderLayout.NORTH);
        leaderBoardFrame.add(scrollPane, BorderLayout.CENTER);
        leaderBoardFrame.add(buttonPanel, BorderLayout.SOUTH);

        leaderBoardFrame.pack();
        leaderBoardFrame.setResizable(false);
        leaderBoardFrame.setLocationRelativeTo(null);
        leaderBoardFrame.setVisible(true);
    }
}
