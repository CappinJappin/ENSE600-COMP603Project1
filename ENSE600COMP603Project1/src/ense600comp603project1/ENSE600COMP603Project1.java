package ense600comp603project1;

//JAMS COMMIT CODE
//Jams' Push Upstream Line
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Keno0
 */
/**
 * Todo: Ken:
 *
 * Better CLI (in its own class, maybe separate fo input and output), Fix player
 * scoring to not overwrite names, Simplify loops into more functions. Random
 * Math questions, allow users to quit during, Have actual questions, Have 50/50
 * x3 times. Fix toString in Questions class, add comments.
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
                    System.out.println("Questions " + questionsNumber + ":\n" + currentQuestions.get(i).getQuestionText());
                    System.out.println("A: " + currentQuestions.get(i).getAnswer(0) + " B: " + currentQuestions.get(i).getAnswer(1) + "\nC: " + currentQuestions.get(i).getAnswer(2) + " D: " + currentQuestions.get(i).getAnswer(3));

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
                    System.out.println("Correct. You chose " + currentQuestions.get(i).getAnswer(answerPosition) + ".");
                    userScore = userScore + 1000;
                } else {
                    System.out.println("Incorrect. You chose " + currentQuestions.get(i).getAnswer(answerPosition) + ". The Correct answer " + currentQuestions.get(i).getCorrectAnswer() + ".");
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
        } catch (Exception ex) {
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
