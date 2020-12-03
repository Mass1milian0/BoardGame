import greenfoot.Color;

/**
 * Board of board game.
 * 
 * @author (Francisco Guerra) 
 * @version (Version 2)
 */
public class Board extends BoardWorld {
    private String[][] cellColor = new String[][] {
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
    public Board() {  
        super(12, 12, 50); 
        setBackground(Color.BLUE, cellColor);
        addObject(new Dorothy(), 0, 0);
    }
    
    public Dorothy getDorothy() {
    	return oldestActor(Dorothy.class);
    }

}
