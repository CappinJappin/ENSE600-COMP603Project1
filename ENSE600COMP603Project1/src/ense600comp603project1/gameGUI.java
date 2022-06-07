package ense600comp603project1;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
/**
 * 
 * @author Ken Zheng(18026410)
 */
public class gameGUI {
    
    JList<String> quizNames = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JSplitPane splitPane = new JSplitPane();
    
    public gameGUI() {
        
        quizNames.setModel(model);
        splitPane.setTopComponent(new JScrollPane(quizNames));
        
    }

}
