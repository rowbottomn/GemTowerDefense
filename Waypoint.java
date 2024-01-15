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
    private SpawnerWPath spawner;//this holds the spawner that waypont belongs to
    
    public Waypoint(int x, int y){
        GreenfootImage img = getImage();
        img.scale(size,size);
       
        this.x = x;
        this.y = y;
    }  
    
    public Waypoint(SpawnerWPath spawner, int x, int y){
        this(x,y);
        this.spawner = spawner;
    }  
    
    /**
     * Act - do whatever the Waypoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //largely empty currently
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
    
    public void addedToWorld(World world){
        System.out.println("added to the world");
        game = (Game)getWorld();//get a world reference
        path = spawner.getPath();//to give the path to the Enemy objects
        setLocation(x, y);//to move to the proper spot in the world
        index = path.indexOf(this);//so it can pass along the next waypoint
        if(index<path.size()-1){
            next = path.get(index+1);    
        }
    }
}