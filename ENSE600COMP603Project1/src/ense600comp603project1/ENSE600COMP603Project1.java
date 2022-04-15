package ense600comp603project1;

//JAMS COMMIT CODE
//Jams' Push Upstream Line
//Extra line to fix weird pull error
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
 * 
 * To Do: Ken:
 * [] Fix player scoring to not overwrite names,
 * [] Simplify loops into more functions.
 * [] Random Math questions
 * [] allow users to quit anytime
 * [] Have actual questions
 * [] Have 50/50 x3 times
 * [] Fix toString in Questions class
 * [] Better CLI (Command Line Interface: in its own class, maybe separate fo input and output),
 * 
 * James:
 * [X] Fix Question Count
 * [] add comments.
 * 
 * Assignment Requirements:
 * [] User Interface 
 * [] File I/O 
 * [] Collections
 * [] Threads
 * [] Software functionality (Easy to Use, no bugs) 
 * [] Software Design (Easy to Understand Code, use comments, OOP) 
 * [] Split Work & Show Each Contribution 
 * 
 */
public class ENSE600COMP603Project1 {
    
    public static void main(String[] args) {

        final int MAX_LEVELS = 3; //there are currently 3 levels: easy, medium, hard
        final int MAX_QUESTIONS = 1; //number of questions per level
        Scanner sc = new Scanner(System.in);
        int userScore = 0;
        int ASCIIAnswers;
        int questionsNumber = 0;
        
        //Question Levels (easy, medium, hard)
        List<Question> questionsEasy = readQuestions("EasyQuestions");
        List<Question> questionsMedium = readQuestions("MeduimQuestions");
        List<Question> questionsHard = readQuestions("HardQuestions");
        List<Question> questions = null;

        //Intro
        System.out.println("Welcome to \"Who Wants To Be A Millionaire\"");
        System.out.println();
        
        for (int d = 0; d < MAX_LEVELS; d++) {

            switch (d) {
                case 0: questions = questionsEasy; break;
                case 1: questions = questionsMedium; break;
                case 2: questions = questionsHard; break;
                default: break;
            }

            for (int q = 0; q < (questions.size() < MAX_QUESTIONS ? questions.size() : MAX_QUESTIONS); q++) {
                questionsNumber++;

                //Ask the Question
                System.out.println("Question " + questionsNumber + ":\n" + questions.get(q).getQuestionText());

                //announce the Options
                System.out.println("A: " + questions.get(q).getAnswer(0)
                        + " B: " + questions.get(q).getAnswer(1)
                        + "\nC: " + questions.get(q).getAnswer(2)
                        + " D: " + questions.get(q).getAnswer(3));

                //User Input (letter A, B, C or D)
                ASCIIAnswers = inputChecker();

                int answerPosition = ASCIIAnswers - (int) "A".charAt(0);

                if (questions.get(q).getAnswer(answerPosition) == questions.get(q).getCorrectAnswer()) {
                    System.out.println("Correct. You chose " + questions.get(q).getAnswer(answerPosition) + ".");
                    userScore = userScore + 1000;
                } else {
                    System.out.println("Incorrect. You chose " + questions.get(q).getAnswer(answerPosition) + ". The Correct answer " + questions.get(q).getCorrectAnswer() + ".");
                }
            }
        }
        
        //Saving your score
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

    public static List<Question> readQuestions(String difficulty) {

        List<Question> questionsList = new ArrayList<Question>();

        try {

            List<String> questionsLine = Files.readAllLines(Paths.get("./resources/" + difficulty + ".txt"));

            for (int i = 0; i < questionsLine.size(); i++) {
                questionsList.add(new Question(questionsLine.get(i).split("@")));
            }
        } catch (Exception ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.shuffle(questionsList);

        return questionsList;
    }

    public static void writeFile(String newUserName, int newScore) throws FileNotFoundException {

        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter(new FileWriter("./resources/Players.txt", true));
        } catch (IOException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }

        pw.println(newUserName + "@" + newScore);

        pw.close();
    }
    
    public static int inputChecker() {

        Scanner sc = new Scanner(System.in);
        int ASCIIinput;

        while (true) {
            //User Input (letter A, B, C or D)
            char userInputAnswer = sc.next().charAt(0);

            ASCIIinput = (int) (Character.toUpperCase(userInputAnswer));

            if (ASCIIinput >= (int) "A".charAt(0) && ASCIIinput <= (int) "D".charAt(0)) {
                break;
            } else {
                System.out.println("Invaild input, please enter a letter:");

            }
        }
        
        return ASCIIinput;
    }
}
