package Zhafran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
import java.awt.Color;

public class Register implements ActionListener {
    private static JFrame registerFrame;
    private static JLabel registerTitle, usernameTitle, passwordTitle, toLogin, planeImageSet, cloudImageSet, alert;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JButton registerButton, toLoginButton;
    private static Font registerFont, usernameFont, passwordFont, loginButtonFont, loginLabelFont, registerButtonFont;

    public static void main(String[] args) {

        // Main Register frame
        registerFrame = new JFrame("Register");
        registerFrame.setSize(400, 600);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.getContentPane().setBackground(Color.WHITE);

        // Register Title
        registerTitle = new JLabel("Register");
        registerTitle.setBounds(125, 50, 160, 45);
        registerFont = new Font("Bookman Old Style", Font.BOLD, 36);
        registerTitle.setFont(registerFont);
        registerFrame.add(registerTitle);

        // Username Title
        usernameTitle = new JLabel("Username:");
        usernameTitle.setBounds(50, 150, 100, 45);
        usernameFont = new Font("Cambria", Font.PLAIN, 18);
        usernameTitle.setFont(usernameFont);
        usernameTitle.setForeground(Color.BLACK);
        registerFrame.add(usernameTitle);

        // Password Title
        passwordTitle = new JLabel("Password:");
        passwordTitle.setBounds(50, 200, 100, 45);
        passwordFont = new Font("Cambria", Font.PLAIN, 18);
        passwordTitle.setFont(passwordFont);
        registerFrame.add(passwordTitle);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(150, 160, 200, 30);
        registerFrame.add(usernameField);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 210, 200, 30);
        registerFrame.add(passwordField);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(50, 260, 300, 40);
        registerButtonFont = new Font("Cambria", Font.BOLD, 20);
        registerButton.setFont(registerButtonFont);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.BLUE);
        registerButton.addActionListener(new Register());
        registerFrame.add(registerButton);

        // Login Label
        toLogin = new JLabel("Already Have an Account?");
        toLogin.setBounds(70, 320, 300, 40);
        loginLabelFont = new Font("Cambria", Font.PLAIN, 14);
        toLogin.setFont(loginLabelFont);
        registerFrame.add(toLogin);

        // Login Button
        toLoginButton = new JButton("Login");
        toLoginButton.setBounds(235, 332, 90, 20);
        loginButtonFont = new Font("Cambria", Font.BOLD, 14);
        toLoginButton.setFont(loginButtonFont);
        toLoginButton.setForeground(Color.WHITE);
        toLoginButton.setBackground(Color.BLUE);
        toLoginButton.addActionListener(new Register());
        registerFrame.add(toLoginButton);

        // Images
        ImageIcon PlaneImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\Images\\plane.png");
        planeImageSet = new JLabel(PlaneImage);
        planeImageSet.setBounds(140, 400, 100, 100);

        ImageIcon CloudImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Zhafran\\Images\\clouds.png");
        cloudImageSet = new JLabel(CloudImage);
        cloudImageSet.setBounds(0, 0, 400, 400);
        registerFrame.add(cloudImageSet);
        registerFrame.add(planeImageSet);

        registerFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {

        } else if (e.getSource() == toLoginButton) {
            Login lgn = new Login();
            // lgn.setVisible(true);

            // lgn.getLoginFrame();
            // JFrame loginFrame = Login.getLoginFrame();
            // if (loginFrame != null) {
            //     loginFrame.setVisible(true);

            }
        }

    }
// }
