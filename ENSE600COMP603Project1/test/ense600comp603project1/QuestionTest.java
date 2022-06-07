package ense600comp603project1;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James Dinsdale(18019702)
 */
public class QuestionTest {
    
//    public QuestionTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of toString method, of class Question.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Question instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionText method, of class Question.
     */
    @Test
    public void testGetQuestionText() {
        System.out.println("getQuestionText");
        Question instance = new Question("why?","because","because","because","because");
        System.out.println(instance.getQuestionText());
        System.out.println(instance.getAnswer(0));
    }

    /**
     * Test of getRightAnswer method, of class Question.
     */
    @Test
    public void testGetRightAnswer() {
        System.out.println("getRightAnswer");
        Question instance = null;
        String expResult = "";
        String result = instance.getRightAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class Question.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        int answerPosition = 0;
        Question instance = null;
        String expResult = "";
        String result = instance.getAnswer(answerPosition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFiftyFifty method, of class Question.
     */
    @Test
    public void testGetFiftyFifty() {
        System.out.println("getFiftyFifty");
        Question instance = null;
        List<String> expResult = null;
        List<String> result = instance.getFiftyFifty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readQuestions method, of class Question.
     */
    @Test
    public void testReadQuestions() {
        System.out.println("readQuestions");
        String difficulty = "";
        List<Question> expResult = null;
        List<Question> result = Question.readQuestions(difficulty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
