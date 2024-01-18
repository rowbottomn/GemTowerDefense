import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class baseObjective here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseObjective extends Actor
{
    /**
     * Act - do whatever the baseObjective wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health;

    
    //health gets decremented with each enemy hitting it
    public BaseObjective(){
        health = 2000;
        GreenfootImage img = getImage();
        img.scale(120,120);
    }
    
    public int getHealth(){
        return health;
    }
    
    public void takeDamage(int dmg){
        health = health - dmg;
        System.out.println(health);
    }
    
    public void setHealth(int amt){
        health = amt;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
