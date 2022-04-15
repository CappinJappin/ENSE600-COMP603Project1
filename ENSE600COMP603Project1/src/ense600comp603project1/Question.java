package ense600comp603project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ken Zheng and James Dinsdale
 */
public class Question {

    private String questionText;
    private String correctAnswer;
    private List<String> answers = new ArrayList<>();

    //To String
    @Override
    public String toString()
    {
        //CODE
        return "[no Questions toString() yet]";
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
}