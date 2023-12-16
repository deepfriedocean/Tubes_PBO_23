package Zhafran.Pages;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class MainPage {
  private static JFrame mainFrame;
  private static JLabel mainTitle, cloudImageSet, planeImageSet;
  private static JButton playButton, leaderBoardButton, profileButton;
  private static Font mainFont;

  public static void main(String[] args) {

    // Main Register frame
    mainFrame = new JFrame("Main Page");
    mainFrame.setSize(400, 600);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setLayout(null);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.getContentPane().setBackground(Color.decode("#D2EAEE"));

    // ImageIcon planeGif = new ImageIcon(
    // "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented
    // Programming\\Tugas_Besar\\Zhafran\\LoginRegister\\Images\\red_plane.gif");

    // planeGifLabel = new JLabel(planeGif);
    // planeGifLabel.setBounds(50, 50, planeGif.getIconWidth(),
    // planeGif.getIconHeight());

    // mainFrame.add(planeGifLabel);

    // Main Title
    mainTitle = new JLabel("Aero Dodge");
    mainTitle.setBounds(80, 50, 230, 45);
    mainFont = new Font("Showcard Gothic", Font.BOLD, 36);
    mainTitle.setForeground(Color.decode("#3BBBBB"));
    mainTitle.setFont(mainFont);
    mainFrame.add(mainTitle);

    // Start Button
    ImageIcon startButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\Images\\startButton.png");
    playButton = new JButton(startButtonIMG);
    playButton.setBounds(90, 300, 200, 63);
    mainFrame.add(playButton);

    // Profile Button
    ImageIcon profileButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\Images\\profile.png");
    profileButton = new JButton(profileButtonIMG);
    profileButton.setBounds(335, 508, 38, 45);
    mainFrame.add(profileButton);

    // Leaderboard Button
    ImageIcon leaderboardButtonIMG = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\Images\\leaderboard.png");
    leaderBoardButton = new JButton(leaderboardButtonIMG);
    leaderBoardButton.setBounds(10, 500, 50, 50);
    mainFrame.add(leaderBoardButton);

    // Images
    ImageIcon planeImage = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\LoginRegister\\Images\\plane.png");
    planeImageSet = new JLabel(planeImage);
    planeImageSet.setBounds(140, 150, 100, 100);
    mainFrame.add(planeImageSet);

    ImageIcon cloudImage = new ImageIcon(
        "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\LoginRegister\\Images\\clouds.png");
    cloudImageSet = new JLabel(cloudImage);
    cloudImageSet.setBounds(0, 100, 400, 400);
    mainFrame.add(cloudImageSet);

    mainFrame.setVisible(true);

  }
}
