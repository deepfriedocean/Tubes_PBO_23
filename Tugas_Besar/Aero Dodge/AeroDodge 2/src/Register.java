import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

import Database.DatabaseManager;

import java.awt.Color;

public class Register implements ActionListener {
    public static JFrame registerFrame;
    private static JLabel registerTitle, usernameTitle, passwordTitle, toLogin, planeImageSet, cloudImageSet, alert;
    private static JTextField usernameField;
    private static JPasswordField passwordField,confirmPasswordTitle;
    private static JButton registerButton, toLoginButton;
    private static Font registerFont, usernameFont, passwordFont, loginButtonFont, loginLabelFont, registerButtonFont;
    private DatabaseManager dodgeDB;

    public Register(){
        dodgeDB = new DatabaseManager();
        frameRegister();
    }

    public void frameRegister(){
        // Main Register frame
        registerFrame = new JFrame("Register");
        registerFrame.setSize(400, 600);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.getContentPane().setBackground(Color.WHITE);
        registerFrame.setResizable(false);

        // Register Title
        registerTitle = new JLabel("Register");
        registerTitle.setBounds(125, 50, 160, 45);
        registerFont = new Font("Bookman Old Style", Font.BOLD, 36);
        registerTitle.setFont(registerFont);
        registerFrame.add(registerTitle);

        // Username Title
        usernameTitle = new JLabel("Username:");
        usernameTitle.setBounds(50, 100, 100, 45);
        usernameFont = new Font("Cambria", Font.PLAIN, 16);
        usernameTitle.setFont(usernameFont);
        usernameTitle.setForeground(Color.BLACK);
        registerFrame.add(usernameTitle);

        // Password Title
        passwordTitle = new JLabel("Password:");
        passwordTitle.setBounds(50, 160, 100, 45);
        passwordFont = new Font("Cambria", Font.PLAIN, 16);
        passwordTitle.setFont(passwordFont);
        registerFrame.add(passwordTitle);

        // Confirm Password Title
        passwordTitle = new JLabel("Confirm Password:");
        passwordTitle.setBounds(50, 220, 150, 45);
        passwordFont = new Font ("Cambria", Font.PLAIN, 16);
        passwordTitle.setFont(passwordFont);
        registerFrame.add(passwordTitle);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 200, 300, 30);
        registerFrame.add(passwordField);

        // Confirm Password Field
        confirmPasswordTitle = new JPasswordField();
        confirmPasswordTitle.setBounds(50, 260, 300, 30);
        registerFrame.add(confirmPasswordTitle);


        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(50, 140, 300, 30);
        registerFrame.add(usernameField);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(50, 310, 300, 40);
        registerButtonFont = new Font("Cambria", Font.BOLD, 20);
        registerButton.setFont(registerButtonFont);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(Color.BLUE);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton(evt);
            }
        });
        registerFrame.add(registerButton);

        // Login Label
        toLogin = new JLabel("Already Have an Account?");
        toLogin.setBounds(70, 360, 300, 40);
        loginLabelFont = new Font("Cambria", Font.PLAIN, 14);
        toLogin.setFont(loginLabelFont);
        registerFrame.add(toLogin);

        // Login Button
        toLoginButton = new JButton("Login");
        toLoginButton.setBounds(250, 372, 90, 20);
        loginButtonFont = new Font("Cambria", Font.BOLD, 14);
        toLoginButton.setFont(loginButtonFont);
        toLoginButton.setForeground(Color.WHITE);
        toLoginButton.setBackground(Color.BLUE);
        toLoginButton.addActionListener(this);
        registerFrame.add(toLoginButton);

        // Images
        ImageIcon PlaneImage = new ImageIcon(
            "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\plane.png");
        planeImageSet = new JLabel(PlaneImage);
        planeImageSet.setBounds(140, 400, 100, 100);

        ImageIcon CloudImage = new ImageIcon(
            "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\clouds.png"); // Replace with the correct path
        cloudImageSet = new JLabel(CloudImage);
        cloudImageSet.setBounds(0, 0, 400, 400);
        registerFrame.add(cloudImageSet);
        registerFrame.add(planeImageSet);

        registerFrame.setVisible(true);
    }

    private void registerButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmRegisterBTNActionPerformed
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordTitle.getPassword());

        if (!username.isEmpty() && !password.isEmpty()) {
            if (password.equals(confirmPassword)) {
                // DatabaseManager typeTestDB = new TypeTestDB();
                dodgeDB.register(username, password);


                // MainFrame parentFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
                // parentFrame.showLoginPanel();
                Login login = new Login(); // Open the login frame
                login.getLoginFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Password Tidak Cocok");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Harap Isi Nama dan Kata Sandi");
        }
    }

    public JFrame getRegisterFrame() {
        return registerFrame;
    }

    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == toLoginButton) {
            redirectToLogin();
        }
    }

    private void redirectToLogin() {
        registerFrame.setVisible(false); // Close the registration frame
        Login login = new Login(); // Open the login frame
        login.getLoginFrame().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Register());
    }
}
