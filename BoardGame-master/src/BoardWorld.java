import java.lang.reflect.Field;

import greenfoot.*;

/**
 * Extends greenfoot.World including cell color management.
 * 
 * @author (Francisco Guerra) 
 * @version (Version 1)
 */
public abstract class BoardWorld extends World {

    public BoardWorld(int worldWidth, int worldHeight, int cellSize) {
        super(worldWidth, worldHeight, cellSize);
    }

    public BoardWorld(int worldWidth, int worldHeight, int cellSize, boolean bounded) {
        super(worldWidth, worldHeight, cellSize, bounded);
    }

    /**
     * Check the color of cell(x,y)
     * 
     * @param x axis of cell
     * @param y axis of cell
     * @param color of cell that is tested
     * @return true when cell(x,y) color is color
     */
    public boolean isCellColor(int x, int y, Color color) {
        return getCellColor(x, y).equals(color);
    }

    /**
     * Returns the color of the cell that is in the point (x, y)
     * 
     * @param x position on x axis
     * @param y position on y axis
     * @return inside color
     */
    public Color getCellColor(int x, int y) {
        return getCellInsideColor(x, y);
    }

    /**
     * Returns the color border of the cell that is in the point (x, y)
     * 
     * @param x position on x axis
     * @param y position on y axis
     * @return border color
     */
    public Color getCellBorderColor(int x, int y) {
        return getBackground().getColorAt(x * getCellSize(),
            y * getCellSize());
    }

    /**
     * Returns the color inside of the cell that is in the point (x, y)
     * 
     * @param x position on x axis
     * @param y position on y axis
     * @return inside color
     */
    public Color getCellInsideColor(int x, int y) {
        if (getCellSize()<3) {
            return getCellBorderColor(x, y);
        } else {
            return getBackground().getColorAt(x * getCellSize() + 1,
                y * getCellSize() + 1);
        }
    }

    /**
     * Sets the color of the cell that is in the point (x, y)
     * 
     * @param x position on x axis
     * @param y position on y axis
     * @param color new inside and border color
     */
    public void setCellColor(int x, int y, Color color) {
        if (color != null) {
            if (getCellSize()==1) {
                getBackground().setColorAt(x, y, color);

            } else {
                Color colorActual = getBackground().getColor();
                getBackground().setColor(color);
                getBackground().fillRect(x * getCellSize(),
                    y * getCellSize(), 
                    getCellSize(), 
                    getCellSize());
                getBackground().setColor(colorActual);
            }
        }
    }

    /**
     * Sets the border and inside color of the cell that is in the point (x, y).
     * 
     * @param x position on x axis
     * @param y position on y axis
     * @param borderColor new border color.
     * @param insideColor new inside color when the cell size is less than three 
     *                    the cell has not any inside and this parameter is ignored
     */
    public void setCellColor(int x, int y, Color borderColor, Color insideColor) {
        if (getCellSize()<3) {
            setCellColor(x, y, borderColor);

        } else if (borderColor == null) {
            setCellColor(x, y, insideColor);

        } else if (insideColor != null){
            Color colorActual = getBackground().getColor();
            getBackground().setColor(insideColor);
            getBackground().fillRect(x * getCellSize() + 1,
                y * getCellSize() + 1, 
                getCellSize() - 2, 
                getCellSize() - 2);
            getBackground().setColor(borderColor);
            getBackground().drawRect(x * getCellSize(),
                y * getCellSize(), 
                getCellSize()-1, 
                getCellSize()-1);
            getBackground().setColor(colorActual);

        } else {
            Color colorActual = getBackground().getColor();
            getBackground().setColor(borderColor);
            getBackground().drawRect(x * getCellSize(),
                y * getCellSize(), 
                getCellSize()-1, 
                getCellSize()-1);
            getBackground().setColor(colorActual);    		
        }
    }

    /**
     * Sets the color of all cells
     * 
     * @param color new color of all cells
     */
    public void setBackground(Color color) {
        setBackground(color, color);
    }

    /**
     * Sets the border and inside color of all cells
     * 
     * @param borderColor new border color of all cell
     * @param insideColor new inside color of all cell
     */
    public void setBackground(Color borderColor, Color insideColor) {
        for (int x=0; x<getWidth(); x++) {
            for (int y=0; y<this.getHeight(); y++) {
                setCellColor(x, y, borderColor, insideColor);    
            }
        }
    }

    /**
     * Set the color of all cells when cellColor has the same size
     * of world. When the size is different, it does nothing
     * 
     * @param cellColor is the matrix with the cells colors 
     */
    public void setBackground(String[][] cellColor) {
        if (cellColor.length == getHeight() && cellColor[0].length == getWidth()) {
            setBackground(0, 0, cellColor);
        }
    }

    /**
     * Set the color of all cells when cellColor has the same size
     * of world. When the size is different, it does nothing
     * 
     * @param borderColor is the color of border of all cells
     * @param cellColor is the matrix with the cells colors 
     */
    public void setBackground(Color borderColor, String[][] cellColor) {
        if (cellColor.length == getHeight() && cellColor[0].length == getWidth()) {
            setBackground(0, 0, borderColor, cellColor);
        }
    }

    /**
     * Set the color of region cells that begins in (xLeftUp, yLeftUp)
     * 
     * @param xLeftUp axis of initial cell
     * @param yLeftUp axis of initial cell
     * @param cellColor is the matrix with the colors that are going to be 
     *                  put in the region that starts at (xLeftUp, yLeftUp) 
     */
    public void setBackground(int xLeftUp, int yLeftUp, String[][] cellColor) {
        if (cellColor.length <= getHeight()-yLeftUp && cellColor[0].length <= getWidth()-xLeftUp) {
            for (int x=0; x<cellColor.length; x++) {
                for (int y=0; y<cellColor[0].length; y++) {
                    setCellColor(xLeftUp+y, yLeftUp+x, toColor(cellColor[x][y]));            	
                }
            }
        } 
    }

    /**
     * Set the color of region cells that begins in (xLeftUp, yLeftUp)
     * 
     * @param xLeftUp axis of initial cell
     * @param yLeftUp axis of initial cell
     * @param borderColor is the color of border that are going to be put 
     *                    in the region that starts at (xLeftUp, yLeftUp)
     * @param cellColor is the matrix with the colors that are going to be 
     *                  put in the region that starts at (xLeftUp, yLeftUp) 
     */
    public void setBackground(int xLeftUp, int yLeftUp, Color borderColor, String[][] cellColor) {
        if (cellColor.length <= getHeight()-yLeftUp && cellColor[0].length <= getWidth()-xLeftUp) {
            for (int x=0; x<cellColor.length; x++) {
                for (int y=0; y<cellColor[0].length; y++) {
                    setCellColor(xLeftUp+y, yLeftUp+x, borderColor, toColor(cellColor[x][y]));            	
                }
            }
        } 
    }	

    /**
     * It returns an object of the greenfoot.Color class associated with the 
     * name of the input color. When this color is not any color declared in 
     * greenfoot.Color then return Color.WHITE
     * 
     * @param colorName is the name of color
     * @return greenfoot.Color object associated with colorName or Color.WHITE
     */
    private Color toColor(String colorName) {
        try {
            Field field = Class.forName("greenfoot.Color").getDeclaredField(colorName.toUpperCase());
            return (Color)field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Count the actors number of a class added to the world
     * 
     * @param cls is the class of actor
     * @return the actors number of a class added to the world
     */
    public int actorsNumber(Class<? extends Actor> cls) {
        return getObjects(cls).size();
    }

    /**
     * Count the actors number of a class added to the world at x,y cell
     * 
     * @param cls is the class of actor
     * @return the actors number of a class added to the world at x,y cell
     */
    public int actorsNumberAt(int x, int y, Class<? extends Actor> cls) {
        return getObjectsAt(x, y, cls).size();
    }

    /**
     * Find the oldest actor of a class added to the world
     * 
     * @param cls is the class of actor
     * @return the oldest actor or null when there is not any actor of cls class
     */
    public <T extends Actor> T oldestActor(Class<T> cls) {
        return oldestActor(cls, 0);
    }

    /**
     * Find the nth oldest actor of a class added to the world
     * 
     * @param cls is the class of actor
     * @param nth is the order where it was added
     * @return the nth oldest actor or null when there 
     *         is not any nth oldest actor of cls class
     */
    public <T extends Actor> T oldestActor(Class<T> cls, int nth) {
        if (getObjects(cls).size() > nth) {
            return getObjects(cls).get(nth);
        } else {
            return null;
        }
    }

    /**
     * Find the oldest actor of a class added to the world at x,y cell
     * 
     * @param x X-coordinate of the cell to be checked.
     * @param y Y-coordinate of the cell to be checked.
     * @param cls is the class of actor
     * @return the oldest actor at x,y cell or null when there is  
     *         not any actor of cls class at x,y cell
     */
    public <T extends Actor> T oldestActorAt(int x, int y, Class<T> cls) {
        return oldestActorAt(x, y, cls, 0);
    }

    /**
     * Find the nth oldest actor of a class added to the world at x,y cell
     * 
     * @param x X-coordinate of the cell to be checked.
     * @param y Y-coordinate of the cell to be checked.
     * @param cls is the class of actor
     * @param nth is the order where it was added
     * @return the nth oldest actor at x,y cell or null when there  
     *         is not any nth oldest actor of cls class at x,y cell
     */
    public <T extends Actor> T oldestActorAt(int x, int y, Class<T> cls, int nth) {
        if (getObjectsAt(x, y, cls).size() > nth) {
            return getObjectsAt(x, y, cls).get(nth);
        } else {
            return null;
        }
    }
    
}
