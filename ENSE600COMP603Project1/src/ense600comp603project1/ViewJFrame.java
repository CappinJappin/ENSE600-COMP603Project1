package ense600comp603project1;

public class ViewJFrame extends javax.swing.JFrame {
    //MVC View
    
    public ViewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelScreenTestNav = new javax.swing.JPanel();
        btn00_Settings = new javax.swing.JButton();
        btn01_MainMenu = new javax.swing.JButton();
        btn02_Q = new javax.swing.JButton();
        btn03_saveScore = new javax.swing.JButton();
        btn04_highScores = new javax.swing.JButton();
        JPanelScreens = new javax.swing.JPanel();
        JPanel0_Settings = new javax.swing.JPanel();
        chkboxEnableMusic = new javax.swing.JCheckBox();
        labelPickQuiz = new javax.swing.JLabel();
        comboPickQuiz = new javax.swing.JComboBox<>();
        btn1_MainMenu = new javax.swing.JButton();
        JPanel1_MainMenu = new javax.swing.JPanel();
        btnMakeQuiz = new javax.swing.JButton();
        btnStartQuiz = new javax.swing.JButton();
        btnViewScore = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        JPanel2_Q = new javax.swing.JPanel();
        labelQuestion = new javax.swing.JLabel();
        JPanelZ_Q_Mini = new javax.swing.JPanel();
        JPanelA_Q_Mini_Question = new javax.swing.JPanel();
        btnOptionB = new javax.swing.JButton();
        btnOptionC = new javax.swing.JButton();
        btnOptionD = new javax.swing.JButton();
        btnOptionA = new javax.swing.JButton();
        JPanelB_Q_Mini_Answer = new javax.swing.JPanel();
        labelAnswer = new javax.swing.JLabel();
        btnNextQuestion = new javax.swing.JButton();
        JPanel3_SaveScore = new javax.swing.JPanel();
        JPanel4_Highscores = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelScreenTestNav.setLayout(new java.awt.GridLayout(1, 0));

        btn00_Settings.setText("Settings");
        btn00_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00_SettingsActionPerformed(evt);
            }
        });
        JPanelScreenTestNav.add(btn00_Settings);

        btn01_MainMenu.setText("Main Menu");
        btn01_MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01_MainMenuActionPerformed(evt);
            }
        });
        JPanelScreenTestNav.add(btn01_MainMenu);

        btn02_Q.setText("Question");
        btn02_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02_QActionPerformed(evt);
            }
        });
        JPanelScreenTestNav.add(btn02_Q);

        btn03_saveScore.setText("Save Score");
        btn03_saveScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03_saveScoreActionPerformed(evt);
            }
        });
        JPanelScreenTestNav.add(btn03_saveScore);

        btn04_highScores.setText("Highscores");
        btn04_highScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn04_highScoresActionPerformed(evt);
            }
        });
        JPanelScreenTestNav.add(btn04_highScores);

        getContentPane().add(JPanelScreenTestNav, java.awt.BorderLayout.PAGE_START);

        JPanelScreens.setLayout(new java.awt.CardLayout());

        chkboxEnableMusic.setText("Enable Music?");
        chkboxEnableMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkboxEnableMusicActionPerformed(evt);
            }
        });

        labelPickQuiz.setText("Pick a quiz");

        comboPickQuiz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quiz 1", "Quiz 2" }));

        btn1_MainMenu.setText("Main Menu");

        javax.swing.GroupLayout JPanel0_SettingsLayout = new javax.swing.GroupLayout(JPanel0_Settings);
        JPanel0_Settings.setLayout(JPanel0_SettingsLayout);
        JPanel0_SettingsLayout.setHorizontalGroup(
            JPanel0_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel0_SettingsLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(JPanel0_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkboxEnableMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboPickQuiz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPickQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn1_MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        JPanel0_SettingsLayout.setVerticalGroup(
            JPanel0_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel0_SettingsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(chkboxEnableMusic)
                .addGap(54, 54, 54)
                .addComponent(labelPickQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPickQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn1_MainMenu)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        JPanelScreens.add(JPanel0_Settings, "card6");

        btnMakeQuiz.setText("Make a Quiz");
        btnMakeQuiz.setEnabled(false);

        btnStartQuiz.setText("Start Quiz");
        btnStartQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartQuizActionPerformed(evt);
            }
        });

        btnViewScore.setText("View Score");

        btnSettings.setText("Settings");

        javax.swing.GroupLayout JPanel1_MainMenuLayout = new javax.swing.GroupLayout(JPanel1_MainMenu);
        JPanel1_MainMenu.setLayout(JPanel1_MainMenuLayout);
        JPanel1_MainMenuLayout.setHorizontalGroup(
            JPanel1_MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1_MainMenuLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(JPanel1_MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStartQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMakeQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        JPanel1_MainMenuLayout.setVerticalGroup(
            JPanel1_MainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1_MainMenuLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnStartQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMakeQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSettings)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        JPanelScreens.add(JPanel1_MainMenu, "card2");

        labelQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelQuestion.setText("Where are you right now?");

        JPanelZ_Q_Mini.setLayout(new java.awt.CardLayout());

        btnOptionB.setText("There");

        btnOptionC.setText("Somewhere Else");

        btnOptionD.setText("14th St, Santa Monica, USA");

        btnOptionA.setText("Here");
        btnOptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelA_Q_Mini_QuestionLayout = new javax.swing.GroupLayout(JPanelA_Q_Mini_Question);
        JPanelA_Q_Mini_Question.setLayout(JPanelA_Q_Mini_QuestionLayout);
        JPanelA_Q_Mini_QuestionLayout.setHorizontalGroup(
            JPanelA_Q_Mini_QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelA_Q_Mini_QuestionLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(JPanelA_Q_Mini_QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelA_Q_Mini_QuestionLayout.createSequentialGroup()
                        .addComponent(btnOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelA_Q_Mini_QuestionLayout.createSequentialGroup()
                        .addComponent(btnOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        JPanelA_Q_Mini_QuestionLayout.setVerticalGroup(
            JPanelA_Q_Mini_QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelA_Q_Mini_QuestionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(JPanelA_Q_Mini_QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOptionA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOptionB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JPanelA_Q_Mini_QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOptionD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        JPanelZ_Q_Mini.add(JPanelA_Q_Mini_Question, "card4");

        JPanelB_Q_Mini_Answer.setLayout(new javax.swing.BoxLayout(JPanelB_Q_Mini_Answer, javax.swing.BoxLayout.LINE_AXIS));

        labelAnswer.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAnswer.setText("WRONG");
        JPanelB_Q_Mini_Answer.add(labelAnswer);

        btnNextQuestion.setText("next question");
        btnNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextQuestionActionPerformed(evt);
            }
        });
        JPanelB_Q_Mini_Answer.add(btnNextQuestion);

        JPanelZ_Q_Mini.add(JPanelB_Q_Mini_Answer, "card4");

        javax.swing.GroupLayout JPanel2_QLayout = new javax.swing.GroupLayout(JPanel2_Q);
        JPanel2_Q.setLayout(JPanel2_QLayout);
        JPanel2_QLayout.setHorizontalGroup(
            JPanel2_QLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2_QLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(JPanel2_QLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPanelZ_Q_Mini, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        JPanel2_QLayout.setVerticalGroup(
            JPanel2_QLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2_QLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(JPanelZ_Q_Mini, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPanelScreens.add(JPanel2_Q, "card3");

        javax.swing.GroupLayout JPanel3_SaveScoreLayout = new javax.swing.GroupLayout(JPanel3_SaveScore);
        JPanel3_SaveScore.setLayout(JPanel3_SaveScoreLayout);
        JPanel3_SaveScoreLayout.setHorizontalGroup(
            JPanel3_SaveScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        JPanel3_SaveScoreLayout.setVerticalGroup(
            JPanel3_SaveScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        JPanelScreens.add(JPanel3_SaveScore, "card6");

        javax.swing.GroupLayout JPanel4_HighscoresLayout = new javax.swing.GroupLayout(JPanel4_Highscores);
        JPanel4_Highscores.setLayout(JPanel4_HighscoresLayout);
        JPanel4_HighscoresLayout.setHorizontalGroup(
            JPanel4_HighscoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        JPanel4_HighscoresLayout.setVerticalGroup(
            JPanel4_HighscoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        JPanelScreens.add(JPanel4_Highscores, "card7");

        getContentPane().add(JPanelScreens, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //START THE QUIZ
    private void btnStartQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartQuizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartQuizActionPerformed

    //
    private void btnOptionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOptionAActionPerformed

    private void btn01_MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01_MainMenuActionPerformed
        JPanelScreens.removeAll();
        JPanelScreens.add(JPanel1_MainMenu);
        JPanelScreens.repaint();
        JPanelScreens.revalidate();
    }//GEN-LAST:event_btn01_MainMenuActionPerformed

    private void btnNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextQuestionActionPerformed

    private void chkboxEnableMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkboxEnableMusicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkboxEnableMusicActionPerformed

    private void btn00_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00_SettingsActionPerformed
        JPanelScreens.removeAll();
        JPanelScreens.add(JPanel0_Settings);
        JPanelScreens.repaint();
        JPanelScreens.revalidate();
    }//GEN-LAST:event_btn00_SettingsActionPerformed

    private void btn02_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02_QActionPerformed
        JPanelScreens.removeAll();
        JPanelScreens.add(JPanel2_Q);
        JPanelScreens.repaint();
        JPanelScreens.revalidate();
    }//GEN-LAST:event_btn02_QActionPerformed

    private void btn03_saveScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03_saveScoreActionPerformed
        JPanelScreens.removeAll();
        JPanelScreens.add(JPanel3_SaveScore);
        JPanelScreens.repaint();
        JPanelScreens.revalidate();
    }//GEN-LAST:event_btn03_saveScoreActionPerformed

    private void btn04_highScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn04_highScoresActionPerformed
        JPanelScreens.removeAll();
        JPanelScreens.add(JPanel4_Highscores);
        JPanelScreens.repaint();
        JPanelScreens.revalidate();
    }//GEN-LAST:event_btn04_highScoresActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel0_Settings;
    private javax.swing.JPanel JPanel1_MainMenu;
    private javax.swing.JPanel JPanel2_Q;
    private javax.swing.JPanel JPanel3_SaveScore;
    private javax.swing.JPanel JPanel4_Highscores;
    private javax.swing.JPanel JPanelA_Q_Mini_Question;
    private javax.swing.JPanel JPanelB_Q_Mini_Answer;
    private javax.swing.JPanel JPanelScreenTestNav;
    private javax.swing.JPanel JPanelScreens;
    private javax.swing.JPanel JPanelZ_Q_Mini;
    private javax.swing.JButton btn00_Settings;
    private javax.swing.JButton btn01_MainMenu;
    private javax.swing.JButton btn02_Q;
    private javax.swing.JButton btn03_saveScore;
    private javax.swing.JButton btn04_highScores;
    private javax.swing.JButton btn1_MainMenu;
    private javax.swing.JButton btnMakeQuiz;
    private javax.swing.JButton btnNextQuestion;
    private javax.swing.JButton btnOptionA;
    private javax.swing.JButton btnOptionB;
    private javax.swing.JButton btnOptionC;
    private javax.swing.JButton btnOptionD;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnStartQuiz;
    private javax.swing.JButton btnViewScore;
    private javax.swing.JCheckBox chkboxEnableMusic;
    private javax.swing.JComboBox<String> comboPickQuiz;
    private javax.swing.JLabel labelAnswer;
    private javax.swing.JLabel labelPickQuiz;
    private javax.swing.JLabel labelQuestion;
    // End of variables declaration//GEN-END:variables
}
