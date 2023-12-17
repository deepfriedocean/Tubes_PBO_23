package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DatabaseManager {
    public DatabaseManager(){}
    public void loginUser(String username, String pw){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aerododge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT uname, pw FROM user WHERE uname=? AND pw=?");

            st.setString(1, username);
            st.setString(2, pw);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Behasil");
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal");
            }
            connection.close(); // Pastikan untuk menutup koneksi setelah penggunaan
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public String getUserInfo(String username) {
        String userInfo = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT info FROM user WHERE uname=?");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                userInfo = rs.getString("info"); // Mengambil info pengguna dari kolom 'info'
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userInfo;
    }

    public boolean isLoginSuccessful(String username, String password) {
        boolean loginSuccessful = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT uname, pw FROM user WHERE uname=? AND pw=?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                loginSuccessful = true; // Login successful if there's a matching record
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return loginSuccessful;
    }

    public boolean isUsernameExists(String nama) {
        boolean isExists = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT uname FROM user WHERE uname=?");
            st.setString(1, nama);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                isExists = true;
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return isExists;
    }

    public void register(String nama, String pw) {
        // Pengecekan apakah username sudah terdaftar sebelum proses registrasi
        boolean isExists = isUsernameExists(nama);

        if (isExists) {
            JOptionPane.showMessageDialog(null, "Username Sudah Ada");
        } else {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root",
                        "");
                PreparedStatement st = connection.prepareStatement("INSERT INTO user (uname, pw) VALUES (?, ?)");
                st.setString(1, nama);
                st.setString(2, pw);

                int rowsInserted = st.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                } else {
                    JOptionPane.showMessageDialog(null, "Register Salah");
                }

                connection.close(); // Pastikan untuk menutup koneksi setelah penggunaan
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public int fetchHighScore(int userId) {
        int highScore = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT score FROM score WHERE id_user = ? ORDER BY score DESC LIMIT 1");
            st.setInt(1, userId);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                highScore = rs.getInt("score");
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return highScore;
    }

    public void insertScore(int userId, int newScore) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");

            // Insert a new record for the user regardless of existing score
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO score (id_user, score) VALUES (?, ?)");
            insertStatement.setInt(1, userId);
            insertStatement.setInt(2, newScore);
            insertStatement.executeUpdate();

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public int fetchUserId(String username) {
        int userId = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement("SELECT id FROM user WHERE uname = ?");
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("id");
            }

            connection.close(); // Pastikan untuk menutup koneksi setelah penggunaan
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userId;
    }

    public List<String[]> getHighScores() {
        List<String[]> highScores = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AeroDodge", "root", "");
            PreparedStatement st = connection.prepareStatement(
                    "SELECT user.uname AS nama, MAX(score.score) AS high_score "
                    + "FROM score "
                    + "JOIN user ON score.id_user = user.id "
                    + "GROUP BY user.uname "
                    + "ORDER BY high_score DESC LIMIT 5");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("nama");
                int score = rs.getInt("high_score");
                String[] entry = {nama, Integer.toString(score)};
                highScores.add(entry);
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return highScores;
    }
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost/AeroDodge";
        String username = "root";
        String password = "";

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database!");
            // Perform database operations here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
