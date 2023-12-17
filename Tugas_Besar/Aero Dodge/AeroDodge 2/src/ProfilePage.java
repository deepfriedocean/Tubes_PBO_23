import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Database.DatabaseManager;

import java.awt.*;

public class ProfilePage {
    private static JFrame profileFrame;
    private static JPanel mainPanel, profileNamePanel, namePanel, highScorePanel, buttonPanel;
    private static JLabel profileTitle, nameTitle, highScoreTitle;
    private static JButton goBack, logOut;
    private DatabaseManager dodgeDB;
    private String username;

    public ProfilePage(String username){
        dodgeDB = new DatabaseManager();
        profilPageFrame();
        this.username = username;
        nameTitle.setText("Name: " + username); // Mengatur teks label namaLB dengan username
        int userId = dodgeDB.fetchUserId(username); // Mendapatkan ID pengguna berdasarkan username
        int highScore = dodgeDB.fetchHighScore(userId); // Mendapatkan skor tertinggi pengguna berdasarkan ID
                                                           // pengguna
        highScoreTitle.setText("HighScore: " + highScore);
    }

    public void profilPageFrame(){
        // Main Profile frame
        profileFrame = new JFrame("Profile");
        // profileFrame.setSize(400, 600);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Profile Panel
        mainPanel = new JPanel(new FlowLayout());
        mainPanel.setBackground(Color.decode("#D2EAEE"));
        Dimension panelSize = new Dimension(400, 300);
        mainPanel.setPreferredSize(panelSize);

        // Profile Title Panel
        profileNamePanel = new JPanel(new BorderLayout());
        profileNamePanel.setBackground(Color.decode("#A5C1D0"));
        Dimension profilePanelSize = new Dimension(380, 75);
        profileNamePanel.setPreferredSize(profilePanelSize);

        // Player Profile Name Panel
        namePanel = new JPanel(new BorderLayout());
        namePanel.setBackground(Color.decode("#E8F3F9"));
        Dimension namePanelSize = new Dimension(380, 75);
        namePanel.setPreferredSize(namePanelSize);

        // Player High Score Panel
        highScorePanel = new JPanel(new BorderLayout());
        highScorePanel.setBackground(Color.decode("#E8F3F9"));
        Dimension highScorePanelSize = new Dimension(380, 75);
        highScorePanel.setPreferredSize(highScorePanelSize);

        // Button Panel
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.decode("#8AC1E0"));
        Dimension buttonPanelSize = new Dimension(380, 50);
        buttonPanel.setPreferredSize(buttonPanelSize);

        // Player Profile Name Components
        profileTitle = new JLabel("Profile");
        profileTitle.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        profileTitle.setHorizontalAlignment(SwingConstants.CENTER);
        profileTitle.setVerticalAlignment(SwingConstants.CENTER);
        profileNamePanel.add(profileTitle);

        // Name Panel Components
        nameTitle = new JLabel("Name: ");
        nameTitle.setFont(new Font("Cambria", Font.BOLD, 16));
        namePanel.add(nameTitle, BorderLayout.WEST);

        // High Score Panel Components
        highScoreTitle = new JLabel("High Score: ");
        highScoreTitle.setFont(new Font("Cambria", Font.BOLD, 16));
        highScorePanel.add(highScoreTitle);

        // Buttons
        goBack = new JButton("Go Back");
        logOut = new JButton("Log Out");
        goBack.setBackground(Color.decode("#7DCAA5"));
        logOut.setBackground(Color.decode("#E12115"));
        goBack.setForeground(Color.WHITE);
        logOut.setForeground(Color.WHITE);

        buttonPanel.add(goBack);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(logOut);

        mainPanel.add(profileNamePanel);
        mainPanel.add(namePanel);
        mainPanel.add(highScorePanel);
        // mainPanel.add(buttonPanel);

        profileFrame.add(mainPanel);
        profileFrame.pack();
        profileFrame.setResizable(false);

        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
    }

    public JFrame getProfileFrame() {
        return profileFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProfilePage(""));
    }
}
