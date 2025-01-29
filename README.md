# quizsystem
Java
  
**1) Set Up Your Environment:**
- Ensure you have Java Development Kit (JDK) installed. You can download it from Oracle's website or use OpenJDK.
- Install MySQL server and MySQL Workbench from MySQL's website.
  
**2) Clone the GitHub Repository:**
- Open a terminal or command prompt.
- git clone https://github.com/winhtutwin/quizsystem.git
- cd quizsystem
  
**3) Set Up the MySQL Database:**
CREATE DATABASE quizDB;
USE QuizDB;
CREATE TABLE Admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE Students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE Questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    questionText TEXT NOT NULL,
    answer VARCHAR(255) NOT NULL
);
  
**4) Add MySQL Connector:**
- Download the MySQL Connector/J (JDBC driver) from MySQL's website.
- Place the downloaded JAR file in the project directory.
  
**5) Update Database Connection:**
In the DatabaseConnection.java file, update the database URL, username, and password to match your MySQL setup:
private static final String URL = "jdbc:mysql://localhost:3306/quizDB";
private static final String USER = "your_db_user"; // Replace with your DB username
private static final String PASSWORD = "your_db_password"; // Replace with your DB password
  
**6) Compile the Java Files:**
- Open a terminal or command prompt in the project directory.
- Compile the Java files using the following command (replace mysql-connector-java-x.x.x.jar with the actual name of the JAR file):
javac -cp ".;mysql-connector-java-x.x.x.jar" *.java
  
**7) Run the Application:**
- Execute the main class using the following command:
java -cp ".;mysql-connector-java-x.x.x.jar" Main
