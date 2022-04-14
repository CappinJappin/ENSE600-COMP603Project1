package ense600comp603project1;

/**
 *
 * @author Keno0
 */
public class Players {

    private String firstName;
    private String lastName;
    private int score;

    public Players(String newFirstName, String newLastName, int newScore) {

        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.score = newScore;

    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
}
