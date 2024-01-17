import greenfoot.MouseInfo;
import greenfoot.Actor;

/**
 * Write a description of class Draggable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Draggable  
{
    boolean isDraggable = false;
    boolean isActive = false;
    MouseInfo mouse = null;
    
    public void getMouseInfo();
    
    public void drag();
    
    public boolean canSet();
    
    public void set(int x, int y);
    
    public void set(Actor owner);
    
    public void click();
}
