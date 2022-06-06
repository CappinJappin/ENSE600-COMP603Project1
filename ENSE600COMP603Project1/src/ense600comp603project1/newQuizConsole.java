package ense600comp603project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newQuizConsole {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        newPlayers newPlayer = new newPlayers();
        newQuizDisplay newQuizDisplay = new newQuizDisplay();

        List<String> quizNames = newQuizDisplay.readQuizNames(newQuizDisplay.getTable());
        System.out.println(quizNames);

        System.out.println("enter quiz name");
        String quizName = sc.nextLine();

        List<Question> newQuesions = newQuizDisplay.readQuestions(newQuizDisplay.getQuiz(quizName));

        System.out.println(newQuesions.get(0).getQuestionText());
        System.out.println(newQuesions.get(0).getRightAnswer());
        System.out.println(newQuesions.get(0).getAnswer(0));
        System.out.println(newQuesions.get(0).getAnswer(1));
        System.out.println(newQuesions.get(0).getAnswer(2));

        System.out.println("enter name");
        String name = sc.nextLine();

        System.out.println("enter quizname");
        String quizname = sc.nextLine();

        System.out.println("enter score");
        int score = sc.nextInt();

        System.out.println("enter percentage");
        int percentage = sc.nextInt();

        newPlayer.connectPlayerDB(name, quizname, score, percentage);

    }
}
