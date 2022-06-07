package ense600comp603project1;

/**
 *  Scores are stored in here
 * then transferred to the txt document "Players.txt"
 * 
 * @author Ken Zheng(18026410) and James Dinsdale(18019702)
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