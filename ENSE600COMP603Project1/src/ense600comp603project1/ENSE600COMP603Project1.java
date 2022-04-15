package ense600comp603project1;

//JAMS COMMIT CODE
//Jams' Push Upstream Line
//Extra line to fix weird pull error
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Keno0
 * 
 * To Do: Ken:
 * [x] Fix player scoring to not overwrite names,
 * [] Simplify loops into more functions.
 * [] Random Math questions
 * [x] allow users to quit anytime
 * [] Have actual questions
 * [] Have 50/50 x3 times
 * [x] Fix toString in Questions class
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
 * [X] Threads
 * [] Software functionality (Easy to Use, no bugs) 
 * [] Software Design (Easy to Understand Code, use comments, OOP) 
 * [] Split Work & Show Each Contribution 
 * [] clean up the 'throws' (they should only be a part of MusicLoopThread)
 * 
 */
public class ENSE600COMP603Project1 {
    
    public static void main(String[] args) {

        final int MAX_LEVELS = 3; //there are currently 3 levels: easy, medium, hard
        final int MAX_QUESTIONS = 2; //number of questions per level
        Scanner sc = new Scanner(System.in);
        int userScore = 0;
        int ASCIIAnswers;
        int answerPosition;
        int questionsNumber = 0;
        int powerUp = 3;
        
        //Question Levels (easy, medium, hard)
        List<Question> questionsEasy = Question.readQuestions("EasyQuestions");
        List<Question> questionsMedium = Question.readQuestions("MeduimQuestions");
        List<Question> questionsHard = Question.readQuestions("HardQuestions");
        List<Question> questions = null; //A List of Question objects (question difficulty depends on level)

        //Intro Text
        System.out.println("Welcome to \"Who Wants To Be A Millionaire\"");
        System.out.println();
        
        
        
        //Music Prompt
        System.out.println("Enable Music? y/n");
        MusicLoopThread m = new MusicLoopThread("resources/KevinMacleod.wav",10000); //every 10 seconds, loop music
        Thread t = new Thread(m);
        if(sc.next().toLowerCase().equals("y")) {    //'y' = play music
            t.start(); //START MUSIC THREAD (must close at end of program)
        }
        
        //Questions
        for (int d = 0; d < MAX_LEVELS; d++) {

            switch (d) {
                case 0: questions = questionsEasy; break;
                case 1: questions = questionsMedium; break;
                case 2: questions = questionsHard; break;
                default: break;
            }

            for (int q=0;
                    q<(questions.size()<MAX_QUESTIONS?questions.size():MAX_QUESTIONS);
                    q++) {
                questionsNumber++;

                //Ask the Question
                System.out.println(questions.get(q));
                System.out.println("Question " + questionsNumber + ":\n" + questions.get(q).getQuestionText());

                //announce the Options
                System.out.println("A: " + questions.get(q).getAnswer(0)
                        + " B: " + questions.get(q).getAnswer(1)
                        + "\nC: " + questions.get(q).getAnswer(2)
                        + " D: " + questions.get(q).getAnswer(3));
                
                System.out.println("(P) to use 50/50. You have " + powerUp + " left");

                //User Input (letter A, B, C, D or P)
                ASCIIAnswers = inputChecker(0);
           
                if (ASCIIAnswers == (int) "P".charAt(0) && powerUp != 0 ) {

                    powerUp--;

                    List<String> fiftyFifty = questions.get(q).getFiftyFifty();
                    System.out.println("A: " + fiftyFifty.get(0) + " B: " + fiftyFifty.get(1));

                    ASCIIAnswers = inputChecker(1);

                    answerPosition = ASCIIAnswers - (int) "A".charAt(0);
                    userScore = userScore + answerChecker(fiftyFifty.get(answerPosition), questions.get(q).getCorrectAnswer(), ASCIIAnswers);
                    System.out.println("Your current score is " + userScore + " .\n\n");
   
                } else if (ASCIIAnswers == (int) "P".charAt(0) && powerUp == 0) {

                    while (true) {
                        System.out.println("You are out of 50/50s.");

                        ASCIIAnswers = inputChecker(0);

                        if (ASCIIAnswers != (int) "P".charAt(0)) {
                            break;
                        }
                    }

                    answerPosition = ASCIIAnswers - (int) "A".charAt(0);
                    userScore = userScore + answerChecker(questions.get(q).getAnswer(answerPosition), questions.get(q).getCorrectAnswer(), ASCIIAnswers);
                    System.out.println("Your current score is " + userScore + " .\n\n");

                } else {

                    answerPosition = ASCIIAnswers - (int) "A".charAt(0);
                    userScore = userScore + answerChecker(questions.get(q).getAnswer(answerPosition), questions.get(q).getCorrectAnswer(), ASCIIAnswers);
                    System.out.println("Your current score is " + userScore + " .\n\n");
                }
            }
        }

        t.stop();
        
        //Saving your score
        System.out.println("Your final score is " + userScore + " .");
        System.out.println("Input your name: ");
        sc.nextLine();
        String userName = sc.nextLine();

        Players newPlayer = new Players(userName, userScore);

        try {
            writeFile(newPlayer.getUserName(), newPlayer.getUserScore());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
//    /**
//     * Imports Quiz questions from a file 
//     * @param difficulty
//     * @return 
//     */
//    public static List<Question> readQuestions(String difficulty) {
//        List<Question> questionsList = new ArrayList<Question>();
//        try {
//            List<String> questionsLine = Files.readAllLines(Paths.get("./resources/" + difficulty + ".txt"));
//            for (int i = 0; i < questionsLine.size(); i++) {
//                questionsList.add(new Question(questionsLine.get(i).split("@")));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Collections.shuffle(questionsList);
//        return questionsList;
//    }
    
    /**
     * Writes a Name and Score to the Scores.txt file
     * 
     * @param newUserName
     * @param newScore
     * @throws FileNotFoundException 
     */
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
    
    public static int inputChecker(int powerUpCheck) {

        Scanner sc = new Scanner(System.in);
        int ASCIIinput;

        while (true) {
            //User Input (letter A, B, C or D)
            char userInputAnswer = sc.next().charAt(0);

            ASCIIinput = (int) (Character.toUpperCase(userInputAnswer));
            if (powerUpCheck == 0) {
                if (ASCIIinput >= (int) "A".charAt(0) && ASCIIinput <= (int) "D".charAt(0)) {
                    break;
                } else if (ASCIIinput == (int) "X".charAt(0)) {
                    System.exit(0);
                } else if (ASCIIinput == (int) "P".charAt(0)) {
                    break;
                } else {
                    System.out.println("Invaild input, please enter a letter:");
                }
            } else {
                if (ASCIIinput >= (int) "A".charAt(0) && ASCIIinput <= (int) "B".charAt(0)) {
                    break;
                } else if (ASCIIinput == (int) "X".charAt(0)) {
                    System.exit(0);
                } else {
                    System.out.println("Invaild input, please enter a letter:");
                }
            }
        }

        return ASCIIinput;
    }

    public static int answerChecker(String inputAnswer, String correctAnswer, int ASCIIAnswers) {
        
        int questionScore = 0;
        
        if (inputAnswer == correctAnswer) {
            System.out.println("\n\nCorrect. You chose " + correctAnswer + ".");
            questionScore = questionScore + 1000;
        } else {
            System.out.println("\n\nIncorrect. You chose " + inputAnswer + ". The Correct answer " + correctAnswer + ".");
        }
        
        return questionScore;
    }
}
