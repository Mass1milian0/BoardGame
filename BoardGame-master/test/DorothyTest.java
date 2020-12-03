import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import greenfoot.junitUtils.EventDispatch;
import greenfoot.junitUtils.runner.GreenfootRunner;

/**
* Test of Dorothy class. 
* 
* @author (Francisco Guerra) 
* @version (Version 1)
*/
@RunWith(GreenfootRunner.class)
public class DorothyTest {

    Board   board;	
    Dorothy dorothy;
    
    /* -----------------------------------------
     * --- TESTS DO NOT WORK IF TRACK CHANGES---
     * -----------------------------------------
     * 
     * this happens because tests have been programmed to check dorothy position
     * according to the default track, if track changes, dorothy no longer moves
     * where the tests expect it to move and therefore fail
     */
    
    @Before
    public void setUp() throws Exception { //as the program now works properly, tests must change in order to pass as green
        board   = new Board();
        dorothy = board.getDorothy();
    }

    @Test
    public void testAct() throws Exception { //this test has been changed in order to dispatch the event click in order to make dorothy move
        // Given
        dorothy.setLocation(4, 7);

        // When
        EventDispatch.mouseClicked(4,7); //this has been added in order for the act actually work as it is expecting a mouse click event
        dorothy.act();	

        // Then
        assertEquals(5, dorothy.getX()); 
        assertEquals(7, dorothy.getY()); 
    }

    @Test
    public void testSetDistance() throws Exception {
        // Given
        dorothy.setLocation(4, 7);

        // When
        EventDispatch.mouseClicked(4,7); 
        dorothy.setDistance(5);
        dorothy.act();	

        // Then
        assertEquals(9, dorothy.getX());
        assertEquals(7, dorothy.getY());
    }

    @Test
    public void testMouseClicked() throws Exception {
        // Given
        dorothy.setLocation(4, 7);

        // When
        EventDispatch.mouseClicked(4,7);
        dorothy.act();	

        // Then
        assertEquals(5, dorothy.getX()); 
        assertEquals(7, dorothy.getY());
    }

    @Test
    public void testImageSize() throws Exception {
        // Given

        // When

        // Then
        assertEquals(40, dorothy.getImage().getWidth());
        assertEquals(50, dorothy.getImage().getHeight());
    }

    @Test
    public void testActFrom_0_0_To_1_0() throws Exception {
        // Given
        dorothy.setLocation(0, 0);

        // When
        EventDispatch.mouseClicked(0,0);
        dorothy.act();

        // Then
        assertEquals(1, dorothy.getX());
        assertEquals(0, dorothy.getY());
    }

    @Test
    public void testActFrom_0_1_To_0_2() throws Exception { //this test has been changed in order to work properly
        // Given
        dorothy.setLocation(1, 0);

        // When
        EventDispatch.mouseClicked(1,0);
        dorothy.act();

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(0, dorothy.getY());
    }

    @Test
    public void testActFrom_2_0_To_2_1() throws Exception {
        // Given
        dorothy.setLocation(2, 0);
        
        // When
        dorothy.setBlackCell(1, 0); //this is absolutely needed, the path finding algorithm will always check back before checking down
        EventDispatch.mouseClicked(2,0); //in here it turns 90 degrees AND moves down
        dorothy.act();
        

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(1, dorothy.getY());
    }

    @Test
    public void testActFrom_2_0_To_2_1_AfterTurn() throws Exception {
        // Given
        dorothy.setLocation(2, 0);
        dorothy.turn(90);
        dorothy.setBlackCell(1, 0);
        // When
        EventDispatch.mouseClicked(2,0); 
        dorothy.act();

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(1, dorothy.getY());
    }

    @Test
    public void testActFrom_2_1_To_2_2() throws Exception {
        // Given
        dorothy.setLocation(2, 1);

        // When
        EventDispatch.mouseClicked(2,1); //as the act finds the closest yellow and moves to it, no need to call act 2 times in order to make it turn
        dorothy.act();

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(2, dorothy.getY());
    }

    @Test
    public void testActFrom_0_0_To_2_3() throws Exception {
        // Given
        dorothy.setLocation(0, 0);

        // When
        EventDispatch.mouseClicked(0,0);
        dorothy.act(); // 1,0
        EventDispatch.mouseClicked(1,0);
        dorothy.act(); // 2,0
        EventDispatch.mouseClicked(2,0);
        dorothy.act(); // 2,1
        EventDispatch.mouseClicked(2,1);
        dorothy.act(); // 2,2
        EventDispatch.mouseClicked(2,2);
        dorothy.act(); // 2,3

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(3, dorothy.getY());
    }

}
