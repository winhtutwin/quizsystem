import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizSystem {
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM Questions";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String questionText = rs.getString("questionText");
                String answer = rs.getString("answer");
                questions.add(new Question(questionText, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}