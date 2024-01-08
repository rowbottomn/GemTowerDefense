import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    protected ArrayList<Enemy> waves = new ArrayList<Enemy>();
    protected SimpleTimer spawnTimer;
    protected SimpleTimer waveTimer;
    protected int spawnTime = 0;
    protected int waveTime = 0;
    
    public Spawner(){
        //add a sample enemy into the list
        waves.add(new Enemy());
        //create the wave timer
        waveTimer = new SimpleTimer();
        //create the spawn timer
        spawnTimer = new SimpleTimer();
        spawnTime = 1500;
        waveTime = 5000;
    }
    
    
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    public Enemy spawn(Enemy e){
        return e;
    }
    
    public void setWaveTime(int w){
        waveTime = w;
    }
    
    
}
