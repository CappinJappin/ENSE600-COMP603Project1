package ense600comp603project1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ken Zheng(18026410)
 */
public class newPlayers {
 
    public final DBManager dbManager;
    public final Connection conn;
    public Statement statement;
    
    public newPlayers() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void connectPlayerDB(String newName, String newQuizname, int newScore, int newPercentage){
        try{
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO PLAYER VALUES ('" + newName + "', '" + newQuizname + "', " + newScore + ", " + newPercentage + ")");
            this.statement.executeBatch();
            
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
