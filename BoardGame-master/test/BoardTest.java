import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import greenfoot.junitUtils.runner.GreenfootRunner;
import greenfoot.Color;

/**
* Test of Board class. 
* 
* @author (Francisco Guerra) 
* @version (Version 3)
*/
@RunWith(GreenfootRunner.class)
public class BoardTest {

    // Test example:
    @Test
    public void testUpperLeftCornerColorInYellow() throws Exception {
        // Given ----------- that is, given the object board:
        Board board = new Board();

        // When ------------ that is, when setCellColor is done with yellow:
        board.setCellColor(0, 0, Color.YELLOW);

        // Then ------------ that is, then the result should be yellow color:
        assertEquals(Color.YELLOW, board.getCellColor(0, 0));
    }

    @Test
    public void testBoardConstructor() throws Exception {
        // Given ----------- that is, given the object board:
        Board board = new Board();
        String[][] cellColor = new String[][] {
                { "yellow", "yellow", "yellow", "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan" }, 
                { "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan",   "yellow", "yellow", "yellow", "cyan",   "cyan",   "cyan" }, 
                { "cyan",   "cyan",   "yellow", "cyan",   "yellow", "yellow", "yellow", "cyan",   "yellow", "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "yellow", "yellow", "yellow", "cyan",   "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan" }, 
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan" }, 
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "yellow", "yellow", "yellow", "cyan",   "cyan",   "cyan" }, 
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "cyan" },
                { "cyan",   "cyan",   "cyan",   "cyan",   "cyan",   "yellow", "yellow", "yellow", "yellow", "yellow", "yellow", "red"  } 
            };

        // When ------------ that is, when setCellColor is done with yellow:

        // Then ------------ that is, then the result should be yellow color:
        for (int x=0; x < board.getWidth(); x++) {
            for (int y=0; y < board.getHeight(); y++) {
                assertEquals(Color.BLUE, board.getCellBorderColor(x, y));

                if (cellColor[y][x].equals("cyan")) {
                    assertEquals(Color.CYAN, board.getCellInsideColor(x, y));

                } else if (cellColor[y][x].equals("yellow")) {
                    assertEquals(Color.YELLOW, board.getCellInsideColor(x, y));

                } else {
                    assertEquals(Color.RED, board.getCellInsideColor(x, y));
                }
            }
        }
    }

}
