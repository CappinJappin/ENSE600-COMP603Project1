package ense600comp603project1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Keno0
 */
public class newViewJFrame implements ActionListener{
    
    int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    
    public newViewJFrame() {
        
        frame = new JFrame();
        
        button = new JButton("Cick me");
        button.addActionListener(this);
        
        label = new JLabel("Number of clicks: 0");
        
        panel = new JPanel();
        panel.add(button);
        panel.add(label);
        
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our JFrame");
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new newViewJFrame();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    count++;
    label.setText("Number of clicks: " + count);
    }
}
