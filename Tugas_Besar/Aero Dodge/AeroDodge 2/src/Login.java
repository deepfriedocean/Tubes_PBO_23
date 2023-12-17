import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Database.DatabaseManager;

public class Login implements ActionListener {

    private static JFrame loginFrame;
    private static JLabel loginTitle, usernameTitle, passwordTitle, toRegister, planeImageSet, cloudImageSet, alert;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JButton loginButton, toRegisterButton;
    private static Font loginFont, usernameFont, passwordFont, loginButtonFont, registerLabelFont, registerButtonFont;
    private DatabaseManager dodgeDB;

    public Login() {
        dodgeDB = new DatabaseManager();
        frameLogin();
    }
    public void frameLogin(){
        // Main login frame
        loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 600);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
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
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton(evt);
            }
        });
        loginFrame.add(loginButton);

        // Register Label
        toRegister = new JLabel("Don't have an account?");
        toRegister.setBounds(70, 320, 300, 40);
        registerLabelFont = new Font("Cambria", Font.PLAIN, 14);
        toRegister.setFont(registerLabelFont);
        loginFrame.add(toRegister);

        // Register Button
        toRegisterButton = new JButton("Register");
        toRegisterButton.setBounds(250, 332, 90, 20);
        registerButtonFont = new Font("Cambria", Font.BOLD, 14);
        toRegisterButton.setFont(registerButtonFont);
        toRegisterButton.setForeground(Color.WHITE);
        toRegisterButton.setBackground(Color.BLUE);
        toRegisterButton.addActionListener(this); // Use 'this' as the ActionListener
        loginFrame.add(toRegisterButton);

        // Images
        ImageIcon PlaneImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\plane.png"); // Replace with the correct path
        planeImageSet = new JLabel(PlaneImage);
        planeImageSet.setBounds(140, 400, 100, 100);

        ImageIcon CloudImage = new ImageIcon(
                "C:\\Kuliah\\Ngoding\\Java Codes\\Object Oriented Programming\\Tugas_Besar\\Project Fix\\AeroDodge 2\\assets\\Login\\clouds.png"); // Replace with the correct path
        cloudImageSet = new JLabel(CloudImage);
        cloudImageSet.setBounds(0, 0, 400, 400);
        loginFrame.add(cloudImageSet);
        loginFrame.add(planeImageSet);

        loginFrame.setVisible(true);
    }
    
    public void loginButton(java.awt.event.ActionEvent evt){
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (!username.isEmpty() && !password.isEmpty()) {
            boolean loginSuccessful = dodgeDB.isLoginSuccessful(username, password);

            
            if (loginSuccessful) {
                 JOptionPane.showMessageDialog(null, "Login Sukses");
                 MainPage register = new MainPage(username);
                 DodgeGame.backgroundMusic.play();
                 register.getMainPageFrame().setVisible(true);
                 loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed. Invalid username or password.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Harap isi nama pengguna dan kata sandi.");
        }
    }
    public void redirectToRegister() {
        loginFrame.setVisible(false); // Close the login frame
        Register register = new Register(); // Open the registration frame
        register.getRegisterFrame().setVisible(true);
    }

    public JFrame getLoginFrame() {
        return loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toRegisterButton) {
            redirectToRegister();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
