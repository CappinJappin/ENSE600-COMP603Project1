package ense600comp603project1;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ken Zheng(18026410) and James Dinsdale(18019702)
 * 
 * The Original Main Class, now less used
 * 
 */
public class QuizConsole {
    
    //public static void main(String[] args) {
    public QuizConsole() {
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
        
        System.out.println("A: New Game\nB: View Scores\nX: Quit (Press X any time to quit)");
        sc.nextLine();
        String input = sc.nextLine();
        while(true){
            if (input.toUpperCase().equals("A")){
                break;
            }else if(input.toUpperCase().equals("B")){
                
                HashMap<String, Integer> displayPlayers = readPlayers();
                System.out.println(displayPlayers);
                
                System.out.println("A: New Game\nB: View Scores\nX: Quit (Press X any time to quit)");
                input = sc.nextLine();
                
            }else if (input.toUpperCase().equals("X")){
                System.exit(0);
            }else{
                System.out.println("Invalid input");
                input = sc.nextLine();
            }
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
                    userScore = userScore + answerChecker(fiftyFifty.get(answerPosition), questions.get(q).getRightAnswer(), ASCIIAnswers);
                    System.out.println("Your current score is " + userScore + " .\n");
   
                } else if (ASCIIAnswers == (int) "P".charAt(0) && powerUp == 0) {

                    while (true) {
                        System.out.println("You are out of 50/50s.");

                        ASCIIAnswers = inputChecker(0);

                        if (ASCIIAnswers != (int) "P".charAt(0)) {
                            break;
                        }
                    }

                    answerPosition = ASCIIAnswers - (int) "A".charAt(0);
                    userScore = userScore + answerChecker(questions.get(q).getAnswer(answerPosition), questions.get(q).getRightAnswer(), ASCIIAnswers);
                    System.out.println("Your current score is " + userScore + " .\n\n");

                } else {

                    answerPosition = ASCIIAnswers - (int) "A".charAt(0);
                    userScore = userScore + answerChecker(questions.get(q).getAnswer(answerPosition), questions.get(q).getRightAnswer(), ASCIIAnswers);
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
            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //Hopefully Moved readQuestions() function to Question class
    //------------------------------------------------
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
//            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
        }

        pw.println(newUserName + "@" + newScore);

        pw.close();
    }
    
    public static HashMap<String, Integer> readPlayers(){
        
        HashMap<String, Integer> playerList = new HashMap();
        BufferedReader br = null;
        
        try {
            
            br = new BufferedReader(new FileReader("./resources/Players.txt"));
            String line = "";
            while ((line = br.readLine()) != null){
                String str[] = line.split("@");
                playerList.put(str[0], Integer.parseInt(str[1]));
            }
        } catch(FileNotFoundException ex){
            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (br != null){
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return playerList;
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
