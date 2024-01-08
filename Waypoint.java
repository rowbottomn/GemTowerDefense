import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class Waypoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waypoint extends Actor
{
    private ArrayList<Waypoint> path;
    private Game game;
    private int x, y;
    private int size = 60;
    private int index;
    private Waypoint next;
    
    public Waypoint(int x, int y){
        GreenfootImage img = getImage();
        img.scale(size,size);
       // setImage(img);
        this.x = x;
        this.y = y;

    }  
    
    /**
     * Act - do whatever the Waypoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //get the world reference as a game;
        if(game == null){
            game = (Game)getWorld();
            path = game.getPath();
            index = path.indexOf(this);
            if(index<path.size()-1){
                next = path.get(index+1);    
            }
            
        }
        //also set the next reference
    }
    
    public Waypoint getNext(){
        return next;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int x(){
        if(game!=null){
            return getX();
        }
        else{
            return 0;
        }
    }
    
    public int y(){
        if(game!=null){
            return getY();
        }
        else{
            return 0;
        }
    }    
    
}