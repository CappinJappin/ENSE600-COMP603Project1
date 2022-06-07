package ense600comp603project1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ken Zheng(18026410)
 */
public class newQuizDisplay {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public newQuizDisplay() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public List<Question> readQuestions(ResultSet rs) {
        List<Question> questionsList = new ArrayList<Question>();
        try {
            this.statement = conn.createStatement();
            while (rs.next()) {
                String newQuestion = rs.getString("QUESTIONS");
                String newRightAnswer = rs.getString("RIGHTANSWER");
                String newAnswer1 = rs.getString("ANSWER1");
                String newAnswer2 = rs.getString("ANSWER2");
                String newAnswer3 = rs.getString("ANSWER3");

                questionsList.add(new Question(newQuestion, newRightAnswer, newAnswer1, newAnswer2, newAnswer3));
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return questionsList;
    }

    public List<String> readQuizNames(ResultSet rs) {
        List<String> quizList = new ArrayList<String>();
        try {
            this.statement = conn.createStatement();
            while (rs.next()) {

                String quizName = rs.getString("TABLENAME");

                quizList.add(quizName);
            }
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        quizList.remove("PLAYER");
        return quizList;
    }

    public ResultSet getQuiz(String quizName) {
        ResultSet rs = null;
        try {
            this.statement = conn.createStatement();
            rs = this.statement.executeQuery("SELECT * FROM " + quizName);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public ResultSet getTable() {
        ResultSet rs = null;
        try {
            this.statement = conn.createStatement();
            rs = this.statement.executeQuery("SELECT TABLENAME FROM SYS.SYSTABLES WHERE TABLETYPE='T'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

}
