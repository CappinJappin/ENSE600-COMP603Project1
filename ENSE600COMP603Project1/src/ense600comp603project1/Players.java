package ense600comp603project1;

/**
 *  Scores are stored in here
 * then transferred to the txt document "Players.txt"
 * @author Keno0
 */
public class Players {

    private String userName;
    private int userScore;

    public Players(String newUserName, int newScore) {

        this.userName = newUserName;
        this.userScore = newScore;

    }

    public String getUserName() {
        return userName;
    }
    
    public int getUserScore() {
        return userScore;
    }
}
