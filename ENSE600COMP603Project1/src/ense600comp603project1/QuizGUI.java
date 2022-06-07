package ense600comp603project1;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Mr Me
 */
public class QuizGUI {
    //MVC Model
    
    public static void main(String[] args) {
        //System.out.println("Starting the Old Project1 version...");
        //QuizConsole app = new QuizConsole();
        //System.out.println("And done!");
        EventQueue.invokeLater(() -> {
            //JFrame frame = new ViewJFrame();
            JFrame frame = new ViewJFrame();
            frame.setTitle("Quiz - The Videogame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
//                frame.setTitle("RadioButtonTest");
//               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//               frame.setVisible(true);
        });
    }
}
