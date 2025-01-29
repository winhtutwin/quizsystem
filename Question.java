public class Question {
    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int checkAnswer(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(answer) ? 1 : 0; // 1 point for correct answer
    }
}