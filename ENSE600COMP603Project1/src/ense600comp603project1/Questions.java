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

    @Override
    public String toString()
    {
        //CODE
        return "[no Questions toString() yet]";
    }
    
    public Questions(String[] newQuestions) {

        this.questionText = newQuestions[0];
        this.correctAnswer = newQuestions[1];

        for (int i = 1; i < newQuestions.length; i++) {

            this.answers.add(newQuestions[i]);

        }

        Collections.shuffle(this.answers);

    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getAnswer(int answerPosition) {
        return answers.get(answerPosition);
    }
}
