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
    public final boolean DEBUG = false;
 
    private SpawnerWPath spawner; 
    Basic_Tower tower1;
    private BaseObjective base;
    ArrayList <Waypoint> path;

    DraggableExample thing;
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1040, 600, 1, false); 
        //spawner = new SpawnerWPath();
        spawner = new SpawnerWPath("map1.txt");

        tower1 = new Basic_Tower();
        
        
        
        base = new BaseObjective();
        addObject(spawner,-60,60);
        addObject(tower1,600,300);
        addObject(new Basic_Tower(), 300, 500);
        addObject(new TankEnemy(spawner.getPath()),10,10);
        addObject(new SpeedyEnemy(spawner.getPath()),10,10);
        
        setupGUI();

    }
    
    public void setupGUI(){
        UI gui = new UI();
        gui.setUpGrid();
        
        addObject(gui.l1, 528, 50);
        addObject(gui.l2, 525, 80);
        addObject(gui.l3, 490, 110);
        addObject(gui.getButton(1, 0), 550, 160);
        addObject(gui.getButton(0, 0), 490, 160);
        addObject(gui.getButton(1, 1), 550, 220);
        addObject(gui.getButton(0, 1), 490, 220);
        
        
        System.out.println(gui);
    }
    
    public ArrayList<Waypoint> getPath(){
         return path;   
    }
    
    public BaseObjective getBase(){
        return base;
    }
    
}

