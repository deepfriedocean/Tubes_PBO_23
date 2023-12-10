package Zhafran.LoginRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class Login implements ActionListener {

    private static JFrame loginFrame;
    private static JLabel loginTitle, usernameTitle, passwordTitle, toRegister, planeImageSet, cloudImageSet, alert;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JButton loginButton, toRegisterButton;
    private static Font loginFont, usernameFont, passwordFont, loginButtonFont, registerLabelFont, registerButtonFont;

    public static void main(String[] args) {

        
        // Main login frame
        loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 600);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().setBackground(Color.WHITE);

        // Login Title
        loginTitle = new JLabel("Login");
        loginTitle.setBounds(150, 50, 150, 45);
        loginFont = new Font("Bookman Old Style", Font.BOLD, 36);
        loginTitle.setFont(loginFont);
        loginFrame.add(loginTitle);

        // Username Title
        usernameTitle = new JLabel("Username:");
        usernameTitle.setBounds(50, 150, 100, 45);
        usernameFont = new Font("Cambria", Font.PLAIN, 18);
        usernameTitle.setFont(usernameFont);
        usernameTitle.setForeground(Color.BLACK);
        loginFrame.add(usernameTitle);

        // Password Title
        passwordTitle = new JLabel("Password:");
        passwordTitle.setBounds(50, 200, 100, 45);
        passwordFont = new Font("Cambria", Font.PLAIN, 18);
        passwordTitle.setFont(passwordFont);
        loginFrame.add(passwordTitle);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(150, 160, 200, 30);
        loginFrame.add(usernameField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 210, 200, 30);
        loginFrame.add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 260, 300, 40);
        loginButtonFont = new Font("Cambria", Font.BOLD, 20);
        loginButton.setFont(loginButtonFont);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLUE);
        loginButton.addActionListener(new Login());
        loginFrame.add(loginButton);

        // Register Label
        toRegister = new JLabel("Don't have an account?");
        toRegister.setBounds(70, 320, 300, 40);
        registerLabelFont = new Font("Cambria", Font.PLAIN, 14);
        toRegister.setFont(registerLabelFont);
        loginFrame.add(toRegister);

        // Register Button
        toRegisterButton = new JButton("Register");
        toRegisterButton.setBounds(220, 332, 90, 20);
        registerButtonFont = new Font("Cambria", Font.BOLD, 14);
        toRegisterButton.setFont(registerButtonFont);
        toRegisterButton.setForeground(Color.WHITE);
        toRegisterButton.setBackground(Color.BLUE);
        toRegisterButton.addActionListener(new Login());
        loginFrame.add(toRegisterButton);

        // Images
        ImageIcon PlaneImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\LoginRegister\\Images\\plane.png");
        planeImageSet = new JLabel(PlaneImage);
        planeImageSet.setBounds(140, 400, 100, 100);

        ImageIcon CloudImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\LoginRegister\\Images\\clouds.png");
        cloudImageSet = new JLabel(CloudImage);
        cloudImageSet.setBounds(0, 0, 400, 400);
        loginFrame.add(cloudImageSet);
        loginFrame.add(planeImageSet);

        loginFrame.setVisible(true);
        

    }

    // public static void showLoginFrame() {
    //     loginFrame.setVisible(true);
    // }

    // public void getLoginFrame() {
    //     loginFrame.setVisible(true);
    // }

    // public static JFrame getLoginFrame() {
    // loginFrame.setVisible(true);
    // System.out.println("Berhasil");
    // return loginFrame;
    // }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {

        } else if (e.getSource() == toRegisterButton) {

        }

    }

}
