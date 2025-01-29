import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        String query = "SELECT * FROM Students WHERE username = ? AND password = ?";
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
        String insertQuery = "INSERT INTO Students (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            stmt.executeUpdate();
            System.out.println("Student registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int answerQuestion(Question question, String answer) {
        return question.checkAnswer(answer);
    }
}