package ense600comp603project1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ken Zheng and James Dinsdale
 */
public class Question {

    private String questionText;
    private String rightAnswer;
    private List<String> answers = new ArrayList<>();

    //To String
    @Override
    public String toString() {
        return "";
    }

    //Constructor
    public Question(String newQuestion, String newRightAnswer, String newAnswer1, String newAnswer2, String newAnswer3) {
        this.questionText = newQuestion;
        this.rightAnswer = newRightAnswer;
        
        this.answers.add(newAnswer1);
        this.answers.add(newAnswer2);
        this.answers.add(newAnswer3);

        Collections.shuffle(this.answers);
    }

    //Getters and Setters
    public String getQuestionText() {
        return questionText;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getAnswer(int answerPosition) {
        return answers.get(answerPosition);
    }

    public List<String> getFiftyFifty() {

        int answerIndex = this.answers.indexOf(this.rightAnswer);
        int randomNumber = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);

        List<String> fiftyFifty = new ArrayList<>();
        fiftyFifty.add(this.rightAnswer);
        fiftyFifty.add(this.answers.get((answerIndex + randomNumber) % 4));
        Collections.shuffle(fiftyFifty);

        return fiftyFifty;
    }
    
    
    //-----------------------------------------
    //Moved from QuizConsole - NEED TO CONNECT PROPERLY TO QUIZ CONSOLE AGAIN
    /**
     * Imports Quiz questions from a file 
     * @param difficulty
     * @return 
     */
    public static List<Question> readQuestions(String difficulty) {
        //Create an Arraylist to store all the questions
        List<Question> questionsList = new ArrayList<Question>();
        try {
            //Read a list of questions from the "resources" folder
            List<String> questionsLine = Files.readAllLines(Paths.get("./resources/" + difficulty + ".txt"));
            //Read each question, and add it to the ArrayList
            for (int i = 0; i < questionsLine.size(); i++) {
                //Each questions' description, solution and fake answers are split by @
                //so we can store them in txt files.
                //Here we decode a question back into a String array ( String[] )
                String[] line = questionsLine.get(i).split("@");
                questionsList.add(new Question(line[0],line[1],line[2],line[3],line[4]));
            }
        } catch (Exception ex) {
            //because we're dealing with files, we need to catch errors
            Logger.getLogger(QuizConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.shuffle(questionsList);
        return questionsList;
    }
}
