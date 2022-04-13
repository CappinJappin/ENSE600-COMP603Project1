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
public class ENSE600COMP603Project1 {

    public static void main(String[] args) throws FileNotFoundException {

        List<Questions> questions = readQuestions();
        System.out.println(questions.get(0));
        
        
    }

    public static List<Questions> readQuestions() {

        List<Questions> questionsList = new ArrayList<Questions>();

        try {
            List<String> questionsLine = Files.readAllLines(Paths.get("./resources/Questions.txt"));

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
}