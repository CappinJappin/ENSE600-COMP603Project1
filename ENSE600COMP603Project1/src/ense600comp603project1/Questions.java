package ense600comp603project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Keno0
 */
public class Questions {

    private String questionText;
    private String correctAnswer;

    private List<String> answers = new ArrayList<>();

    public Questions(String[] newQuestions) {

        this.questionText = newQuestions[0];
        this.correctAnswer = newQuestions[1];

        for (int i = 1; i < newQuestions.length; i++) {

            this.answers.add(newQuestions[i]);

        }
    }
    
    @Override
    public String toString(){
        
        Collections.shuffle(answers);
        
        return String.format("%s\nA: %s B: %s\nC: %s D: %s", questionText, answers.get(0), answers.get(1), answers.get(2), answers.get(3));
    }
}
