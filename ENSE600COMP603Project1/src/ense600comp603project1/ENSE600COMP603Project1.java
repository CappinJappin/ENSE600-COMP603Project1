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
import java.util.Random;

/**
 *
 * @author Keno0
 */
public class ENSE600COMP603Project1 {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("hello world");
        
        ArrayList<String> questions = readQuestions();
        System.out.println(questions.get(0));
        System.out.println("A: " + questions.get(1) + " " + "B: " + questions.get(2) + '\n' + "C: " + questions.get(3) + " " + "D: " + questions.get(4)
        );
    }

    public static ArrayList<String> readQuestions() {

        ArrayList<String> list = new ArrayList<String>();

        try {
            String line = Files.readAllLines(Paths.get("./resources/Questions.txt")).get((int) (Math.random() * (5 - 0 + 1) + 0));

            String str[] = line.split("@");

            for (int i = 0; i < 5; i++) {
                list.add(str[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ENSE600COMP603Project1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
