package ense600comp603project1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Keno0
 */
public class newViewJFrame {

    private JLabel Title = new JLabel();
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JButton Start = new JButton();
    private JButton Stats = new JButton();
    private JButton Settings = new JButton();

    public newViewJFrame() {

        //Start button
        Start.setBounds(300, 300, 200, 30);
        Start.addActionListener(e -> {

            frame.getContentPane().removeAll();
            frame.repaint();
            new gameGUI();
        });
        Start.setText("Start Game");
        Start.setFocusable(false);

        //Stats Button
        Stats.setBounds(300, 350, 200, 30);
        Stats.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
        });
        Stats.setText("View Stats");
        Stats.setFocusable(false);

        //Settings Button
        Settings.setBounds(300, 400, 200, 30);
        Settings.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
        });
        Settings.setText("Settings");
        Settings.setFocusable(false);

        Title.setText("Hello World");
        Title.setFont(new Font("Arial", Font.PLAIN, 20));

        frame.setSize(750, 750);
        frame.setTitle("Our JFrame");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(Title);
        frame.add(Start);
        frame.add(Stats);
        frame.add(Settings);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
