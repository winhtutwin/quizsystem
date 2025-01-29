import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizSystem quizSystem = new QuizSystem();

        while (true) {
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Admin Login
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Choose an option: ");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Admin admin = null;
                    if (adminChoice == 1) {
                        System.out.print("Enter Admin Username: ");
                        String adminUsername = scanner.nextLine();
                        System.out.print("Enter Admin Password: ");
                        String adminPassword = scanner.nextLine();
                        admin = new Admin(adminUsername, adminPassword);

                        if (admin.login()) {
                            System.out.println("Admin logged in successfully.");
                            while (true) {
                                System.out.println("1. Create Question");
                                System.out.println("2. Logout");
                                System.out.print("Choose an option: ");
                                int actionChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline

                                if (actionChoice == 1) {
                                    System.out.print("Enter question: ");
                                    String questionText = scanner.nextLine();
                                    System.out.print("Enter answer: ");
                                    String answer = scanner.nextLine();
                                    admin.createQuestion(questionText, answer);
                                } else {
                                    break; // Logout
                                }
                            }
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                    } else if (adminChoice == 2) {
                        System.out.print("Enter Admin Username: ");
                        String newAdminUsername = scanner.nextLine();
                        System.out.print("Enter Admin Password: ");
                        String newAdminPassword = scanner.nextLine();
                        admin = new Admin(newAdminUsername, newAdminPassword);
                        admin.register();
                    }
                    break;

                case 2: // Student Login
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Choose an option: ");
                    int studentChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student student = null;
                    if (studentChoice == 1) {
                        System.out.print("Enter Student Username: ");
                        String studentUsername = scanner.nextLine();
                        System.out.print("Enter Student Password: ");
                        String studentPassword = scanner.nextLine();
                        student = new Student(studentUsername, studentPassword);

                        if (student.login()) {
                            System.out.println("Student logged in successfully.");
                            int score = 0;

                            List<Question> questions = quizSystem.getQuestions();
                            for (Question question : questions) {
                                System.out.println(question.getQuestionText());
                                System.out.print("Your answer: ");
                                String studentAnswer = scanner.nextLine();
                                score += student.answerQuestion(question, studentAnswer);
                            }

                            System.out.println("Your score: " + score + "/" + questions.size());
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                    } else if (studentChoice == 2) {
                        System.out.print("Enter Student Username: ");
                        String newStudentUsername = scanner.nextLine();
                        System.out.print("Enter Student Password: ");
                        String newStudentPassword = scanner.nextLine();
                        student = new Student(newStudentUsername, newStudentPassword);
                        student.register();
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}