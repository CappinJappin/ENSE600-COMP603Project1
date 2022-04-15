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
 * @author Keno0
 */
public class Question {

    private String questionText;
    private String correctAnswer;
    private List<String> answers = new ArrayList<>();

    //To String
    @Override
    public String toString()
    {
        return "";        
    }
    
    //Constructor
    public Question(String[] newQuestions) {
        this.questionText = newQuestions[0];
        this.correctAnswer = newQuestions[1];
        for (int i = 1; i < newQuestions.length; i++) {
            this.answers.add(newQuestions[i]);
        }
        Collections.shuffle(this.answers);
    }
    
    //Getters and Setters
    public String getQuestionText() {return questionText;}
    
    public String getCorrectAnswer() {return correctAnswer;}
    
    public String getAnswer(int answerPosition) {return answers.get(answerPosition);}
    
    public List<String> getFiftyFifty() {
        
        int answerIndex = this.answers.indexOf(this.correctAnswer);
        int randomNumber = (int) Math.floor(Math.random()*(3-1+1)+1);
        
        List<String> fiftyFifty = new ArrayList<>();
        fiftyFifty.add(this.correctAnswer);
        fiftyFifty.add(this.answers.get((answerIndex + randomNumber)%4));
        Collections.shuffle(fiftyFifty);
        
        return fiftyFifty;
    }
    
    /**
     * Imports Quiz questions from a file 
     * @param difficulty
     * @return 
     */
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
}