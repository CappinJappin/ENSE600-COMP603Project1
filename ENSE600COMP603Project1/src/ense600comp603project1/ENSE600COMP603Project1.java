package ense600comp603project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Keno0
 */
/**
 * Todo: Ken:
 *
 * more questions questions show correct answer players scoring
 *
 */
public class ENSE600COMP603Project1 {

    public static void main(String[] args) {

        final int DIFFICULTY_INDEX = 3;
        final int MAX_CURRENT_QUESTIONS = 10;
        Scanner sc = new Scanner(System.in);
        int userScore = 0;
        int ASCIIAnswers;
        int questionsNumber = 0;

        List<Questions> questionsEasy = readQuestions("EasyQuestions");
        List<Questions> questionsMedium = readQuestions("MeduimQuestions");
        List<Questions> questionsHard = readQuestions("HardQuestions");
        List<Questions> currentQuestions = null;

        for (int j = 0; j < DIFFICULTY_INDEX; j++) {

            if (j == 0) {
                currentQuestions = questionsEasy;
            } else if (j == 1) {
                currentQuestions = questionsMedium;
            } else if (j == 2) {
                currentQuestions = questionsHard;
            }

            for (int i = 0; i < (currentQuestions.size() < MAX_CURRENT_QUESTIONS ? currentQuestions.size() : MAX_CURRENT_QUESTIONS); i++) {

                while (true) {

                    questionsNumber++;
                    System.out.println("Questions " + questionsNumber + ":\n" + currentQuestions.get(i));

                    System.out.println("Please input A, B, C, D");
                    char userInputAnswer = sc.next().charAt(0);

                    ASCIIAnswers = (int) (Character.toUpperCase(userInputAnswer));

                    if (ASCIIAnswers >= (int) "A".charAt(0) && ASCIIAnswers <= (int) "D".charAt(0)) {
                        break;
                    } else {
                        System.out.println("Invaild input.");
                    }
                }

                int answerPosition = ASCIIAnswers - (int) "A".charAt(0);

                if (currentQuestions.get(i).getAnswer(answerPosition) == currentQuestions.get(i).getCorrectAnswer()) {
                    System.out.println("Correct");
                    userScore = userScore + 1000;
                } else {
                    System.out.println("Incorrect");
                }
            }

        }

        System.out.println("Input your name");
        sc.nextLine();
        String userName = sc.nextLine();

        Players newPlayer = new Players(userName, userScore);

        try {
            writeFile(newPlayer.getUserName(), newPlayer.getUserScore());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Questions> readQuestions(String difficulty) {

        List<Questions> questionsList = new ArrayList<Questions>();

        try {

            List<String> questionsLine = Files.readAllLines(Paths.get("./resources/" + difficulty + ".txt"));

            for (int i = 0; i < questionsLine.size(); i++) {
                questionsList.add(new Questions(questionsLine.get(i).split("@")));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.shuffle(questionsList);

        return questionsList;
    }

    public static void writeFile(String newUserName, int newScore) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("./resources/Players.txt");

        pw.println(newUserName + "@" + newScore);

        pw.close();
    }

}