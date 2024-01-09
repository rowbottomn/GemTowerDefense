import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    SpawnerWPath spawner; 
    ArrayList <Waypoint> path;
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1040, 600, 1); 
        spawner = new SpawnerWPath();
        addObject(spawner,60,60);
        
    }
    
    
    
    public ArrayList<Waypoint> getPath(){
         return null;   
    }
}

