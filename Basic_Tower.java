import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Basic_Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basic_Tower extends Actor

{
    private int dmg;
    private int timer;
    private int cost;
    private int fireRate;
    private int range;
    private int radius;
    
    public Basic_Tower(){
        dmg = 5;
        timer = 10;
        fireRate = 30; //firing after 30 frames (once half second)
        range = 100;
        radius = 500;
        
    }
    
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer++;
        if(timer > fireRate){
            List<Enemy>victims = getObjectsInRange(radius, Enemy.class);
            if(victims.size() > 0){
                Enemy victim = victims.get(0);
                getWorld().addObject(new Bullet(victim), getX(),getY());
                timer = 0;
            }
        }
        
    }
    
}
