import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        String query = "SELECT * FROM Admins WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void register() {
        String insertQuery = "INSERT INTO Admins (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            stmt.executeUpdate();
            System.out.println("Admin registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createQuestion(String questionText, String answer) {
        String insertQuery = "INSERT INTO Questions (questionText, answer) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, questionText);
            stmt.setString(2, answer);
            stmt.executeUpdate();
            System.out.println("Question created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}