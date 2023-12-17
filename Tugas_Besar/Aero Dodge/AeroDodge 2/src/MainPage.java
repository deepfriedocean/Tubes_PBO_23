import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;


import Database.DatabaseManager;

import java.awt.Color;

public class MainPage {
  public static JFrame mainFrame;
  private static JLabel mainTitle, cloudImageSet, planeImageSet;
  private static JButton playButton, leaderBoardButton, profileButton;
  private static Font mainFont;
  private String username;

  public MainPage(String username){
    this.username = username;
    mainFramePage();
  }

  public void mainFramePage(){
    // Main Register frame
    mainFrame = new JFrame("Main Page");
    mainFrame.setSize(400, 600);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setLayout(null);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.getContentPane().setBackground(Color.decode("#D2EAEE"));

    mainTitle = new JLabel("Aero Dodge");
    mainTitle.setBounds(80, 50, 230, 45);
    mainFont = new Font("Showcard Gothic", Font.BOLD, 36);
    mainTitle.setForeground(Color.decode("#3BBBBB"));
    mainTitle.setFont(mainFont);
    mainFrame.add(mainTitle);

    // Start Button
    ImageIcon startButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\startButton.png");
    playButton = new JButton(startButtonIMG);
    playButton.setBounds(90, 300, 200, 63);
    playButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            startButton(evt);
        }
    });
    mainFrame.add(playButton);

    // Profile Button
    ImageIcon profileButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\profile.png");
    profileButton = new JButton(profileButtonIMG);
    profileButton.setBounds(335, 508, 38, 45);
    profileButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            redirectToProfile(evt);
        }
    });
    mainFrame.add(profileButton);

    // Leaderboard Button
    ImageIcon leaderboardButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\leaderboard.png");
    leaderBoardButton = new JButton(leaderboardButtonIMG);
    leaderBoardButton.setBounds(10, 500, 50, 50);
    leaderBoardButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        redirectToLeaderboard(evt);
      }
    });
    mainFrame.add(leaderBoardButton);

    // Images
    ImageIcon planeImage = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\plane.png");
    planeImageSet = new JLabel(planeImage);
    planeImageSet.setBounds(140, 150, 100, 100);
    mainFrame.add(planeImageSet);

    ImageIcon cloudImage = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\clouds.png");
    cloudImageSet = new JLabel(cloudImage);
    cloudImageSet.setBounds(0, 100, 400, 400);
    mainFrame.add(cloudImageSet);

    mainFrame.setVisible(true);
  }

  public void startButton(java.awt.event.ActionEvent evt){
    DodgeGame dg = new DodgeGame(username);
    dg.setVisible(true);
    
  }
  public JFrame getMainPageFrame() {
    return mainFrame;
}

  public void redirectToProfile(java.awt.event.ActionEvent evt) {
    ProfilePage profile = new ProfilePage(username);
    JFrame profileFrame = profile.getProfileFrame();
    profileFrame.setVisible(true);
    profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  public void redirectToLeaderboard(java.awt.event.ActionEvent evt) {
    LeaderboardPage Lp = new LeaderboardPage();
    JFrame leaderboardFrame = Lp.getLoginFrame();
    leaderboardFrame.setVisible(true);
    leaderboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


  // public void actionPerformed(ActionEvent e) {
  //     if (e.getSource() == profileButton) {
  //         redirectToProfile();
  //     }
  // }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainPage(""));
  }
}