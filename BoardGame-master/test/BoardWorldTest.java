import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import greenfoot.junitUtils.runner.GreenfootRunner;
import greenfoot.Color;

/**
* Tests of cell color management.
* 
* @author (Francisco Guerra) 
* @version (Version 1)
*/
@RunWith(GreenfootRunner.class)
public class BoardWorldTest {

    private WorldWithCellManager world;

    public class WorldWithCellManager extends BoardWorld {
        public WorldWithCellManager(int size) {
            super (12, 10, size);
        }
    }

    @Before
    public void setUp() throws Exception {
        world = new WorldWithCellManager(50);
        // world = WorldCreator.getWorld
        //            (WorldWithCellManager.class, //=> Inner class
        //             this,                       //=> Outer class
        //             50);                        //=> Paramether
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(12, world.getWidth());
        assertEquals(10, world.getHeight());
        assertEquals(50, world.getCellSize());
    }

    @Test
    public void testSize1() throws Exception {
        world = new WorldWithCellManager(1);
        assertEquals(12, world.getWidth());
        assertEquals(10, world.getHeight());
        assertEquals( 1, world.getCellSize());
    }

    @Test
    public void testSize2() throws Exception {
        world = new WorldWithCellManager(2);
        assertEquals(12, world.getWidth());
        assertEquals(10, world.getHeight());
        assertEquals( 2, world.getCellSize());
    }

    @Test
    public void testSize3() throws Exception {
        world = new WorldWithCellManager(3);
        assertEquals(12, world.getWidth());
        assertEquals(10, world.getHeight());
        assertEquals( 3, world.getCellSize());
    }

    @Test
    public void testCellRed() throws Exception {
        world.setCellColor(2, 3, Color.RED);
        assertEquals(Color.RED, world.getCellColor(2, 3));
    }

    @Test
    public void testCellRed1() throws Exception {
        world = new WorldWithCellManager(1);
        world.setCellColor(2, 3, Color.RED);
        assertEquals(Color.RED, world.getCellColor(2, 3));
    }

    @Test
    public void testCellRed2() throws Exception {
        world = new WorldWithCellManager(2);
        world.setCellColor(2, 3, Color.RED);
        assertEquals(Color.RED, world.getCellColor(2, 3));
    }

    @Test
    public void testCellRed3() throws Exception {
        world = new WorldWithCellManager(3);
        world.setCellColor(2, 3, Color.RED);
        assertEquals(Color.RED, world.getCellColor(2, 3));
    }

    @Test
    public void testCellBlueBorderYellowInside() throws Exception {
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        assertEquals(Color.BLACK, world.getCellBorderColor(5, 6));
        assertEquals(Color.GREEN, world.getCellInsideColor(5, 6));
    }

    @Test
    public void testCellBlueBorderYellowInside1() throws Exception {
        world = new WorldWithCellManager(1);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        assertEquals(Color.BLACK, world.getCellBorderColor(5, 6));
        assertEquals(Color.BLACK, world.getCellInsideColor(5, 6));
    }

    @Test
    public void testCellBlueBorderYellowInside2() throws Exception {
        world = new WorldWithCellManager(2);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        assertEquals(Color.BLACK, world.getCellBorderColor(5, 6));
        assertEquals(Color.BLACK, world.getCellInsideColor(5, 6));
    }

    @Test
    public void testCellBlueBorderYellowInside3() throws Exception {
        world = new WorldWithCellManager(3);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        assertEquals(Color.BLACK, world.getCellBorderColor(5, 6));
        assertEquals(Color.GREEN, world.getCellInsideColor(5, 6));
    }

    @Test
    public void testCellRed_OthersWhite() throws Exception {
        world.setCellColor(2, 3, Color.RED);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==2 && y==3) {
                    assertEquals(Color.RED, world.getCellColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellColor(x, y));					
                }
            }
        }
    }

    @Test
    public void testCellRed_OthersWhite1() throws Exception {
        world = new WorldWithCellManager(1);
        world.setCellColor(2, 3, Color.RED);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==2 && y==3) {
                    assertEquals(Color.RED, world.getCellColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellColor(x, y));					
                }
            }
        }
    }

    @Test
    public void testCellRed_OthersWhite2() throws Exception {
        world = new WorldWithCellManager(2);
        world.setCellColor(2, 3, Color.RED);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==2 && y==3) {
                    assertEquals(Color.RED, world.getCellColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellColor(x, y));					
                }
            }
        }
    }

    @Test
    public void testCellRed_OthersWhite3() throws Exception {
        world = new WorldWithCellManager(3);
        world.setCellColor(2, 3, Color.RED);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==2 && y==3) {
                    assertEquals(Color.RED, world.getCellColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellColor(x, y));					
                }
            }
        }
    }

    @Test
    public void testCellBlueBorderYellowInside_OthersWhite() throws Exception {
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==5 && y==6) {
                    assertEquals(Color.BLACK, world.getCellBorderColor(x, y));
                    assertEquals(Color.GREEN, world.getCellInsideColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellBorderColor(x, y));
                    assertEquals(Color.WHITE, world.getCellInsideColor(x, y));
                }
            }
        }
    }

    @Test
    public void testCellBlueBorderYellowInside_OthersWhite1() throws Exception {
        world = new WorldWithCellManager(1);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==5 && y==6) {
                    assertEquals(Color.BLACK, world.getCellBorderColor(x, y));
                    assertEquals(Color.BLACK, world.getCellInsideColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellBorderColor(x, y));
                    assertEquals(Color.WHITE, world.getCellInsideColor(x, y));
                }
            }
        }
    }

    @Test
    public void testCellBlueBorderYellowInside_OthersWhite2() throws Exception {
        world = new WorldWithCellManager(2);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==5 && y==6) {
                    assertEquals(Color.BLACK, world.getCellBorderColor(x, y));
                    assertEquals(Color.BLACK, world.getCellInsideColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellBorderColor(x, y));
                    assertEquals(Color.WHITE, world.getCellInsideColor(x, y));
                }
            }
        }
    }

    @Test
    public void testCellBlueBorderYellowInside_OthersWhite3() throws Exception {
        world = new WorldWithCellManager(3);
        world.setCellColor(5, 6, Color.BLACK, Color.GREEN);
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                if (x==5 && y==6) {
                    assertEquals(Color.BLACK, world.getCellBorderColor(x, y));
                    assertEquals(Color.GREEN, world.getCellInsideColor(x, y));
                } else {
                    assertEquals(Color.WHITE, world.getCellBorderColor(x, y));
                    assertEquals(Color.WHITE, world.getCellInsideColor(x, y));
                }
            }
        }
    }

    @Test
    public void testSetBackgroundComplete() throws Exception {
        String[][] cellColor = new String[][] {
                { "yellow", "yellow", "yellow", "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan"  , "yellow", "yellow", "yellow", "cyan"  , "cyan"  , "cyan" }, 
                { "cyan"  , "cyan"  , "yellow", "cyan"  , "yellow", "yellow", "yellow", "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "yellow", "yellow", "yellow", "cyan"  , "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan" }, 
                { "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "yellow", "yellow", "yellow", "yellow", "cyan"  , "cyan"  , "cyan" }, 
                { "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "yellow", "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan" },
                { "cyan"  , "cyan"  , "cyan"  , "cyan"  , "cyan"  , "yellow", "yellow", "yellow", "yellow", "yellow", "yellow", "red"  } 
            };
        world.setBackground(cellColor);
        assertEquals(Color.YELLOW, world.getCellColor( 0, 0));
        assertEquals(Color.CYAN,   world.getCellColor( 0, 1));
        assertEquals(Color.RED,    world.getCellColor(11, 9));
    }

    @Test
    public void testSetBackgroundWithNull() throws Exception {
        String[][] cellColor = new String[][] {
                { "yellow", "yellow", "yellow", null    , null    , null    , null    , null    , null    , null    , null    , null   },
                { null    , null    , "yellow", null    , null    , null    , null    , null    , null    , null    , null    , null   },
                { null    , null    , "yellow", null    , null    , null    , "yellow", "yellow", "yellow", null    , null    , null   }, 
                { null    , null    , "yellow", null    , "yellow", "yellow", "yellow", null    , "yellow", null    , null    , null   },
                { null    , null    , "yellow", "yellow", "yellow", null    , null    , null    , "yellow", null    , null    , null   }, 
                { null    , null    , null    , null    , null    , null    , null    , null    , "yellow", null    , null    , null   },
                { null    , null    , null    , null    , null    , null    , null    , null    , "yellow", null    , null    , null   },
                { null    , null    , null    , null    , null    , "yellow", "yellow", "yellow", "yellow", null    , null    , null   }, 
                { null    , null    , null    , null    , null    , "yellow", null    , null    , null    , null    , null    , null   },
                { null    , null    , null    , null    , null    , "yellow", "yellow", "yellow", "yellow", "yellow", "yellow", "red"  } 
            };
        world.setBackground(cellColor);
        assertEquals(Color.YELLOW, world.getCellColor( 0, 0));
        assertEquals(Color.WHITE,  world.getCellColor( 0, 1));
        assertEquals(Color.RED,    world.getCellColor(11, 9));
    }

    @Test
    public void testSetBackgroundRegion() throws Exception {
        String[][] cellColor = new String[][] {
                { "yellow", "yellow", "yellow", null    , null    , null    , null    , null    , null    , null    , null    , null   },
                { null    , null    , "yellow", null    , null    , null    , "yellow", "yellow", "yellow", null    , null    , null   }, 
                { null    , null    , "yellow", null    , "yellow", "yellow", "yellow", null    , "yellow", null    , null    , null   },
                { null    , null    , "yellow", "yellow", "yellow", null    , null    , null    , "yellow", null    , null    , null   }, 
                { null    , null    , null    , null    , null    , null    , null    , null    , "yellow", null    , null    , null   },
                { null    , null    , null    , null    , null    , null    , null    , null    , "yellow", null    , null    , null   },
                { null    , null    , null    , null    , null    , "yellow", "yellow", "yellow", "yellow", null    , null    , null   }, 
                { null    , null    , null    , null    , null    , "yellow", "yellow", "yellow", "yellow", "yellow", "yellow", "red"  } 
            };
        world.setBackground(0, 1, cellColor);
        assertEquals(Color.WHITE,  world.getCellColor( 0, 0));
        assertEquals(Color.YELLOW, world.getCellColor( 0, 1));
        assertEquals(Color.WHITE,  world.getCellColor( 0, 2));
        assertEquals(Color.RED,    world.getCellColor(11, 8));
        assertEquals(Color.WHITE,  world.getCellColor(11, 9));
    }

}
