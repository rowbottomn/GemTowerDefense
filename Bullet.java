import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    protected int range;
    protected int dmg;
    protected int speed;
    protected Enemy victim;
    
    
    public Bullet(Enemy e){
        victim = e;
        speed = 20;
    }
    
    public Bullet(Enemy e, int range, int dmg){
        this.range = range;
        this.dmg = dmg;
        victim = e;
        speed = 20;
    }
    
    
    /**
     * Act - do whatever the Bullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        if(isAtEdge()){
            //System.out.println("outside");
            getWorld().removeObject(this);
        }
    }
    
    protected void addedToWorld(World world){
        turnTowards(victim.getX(),victim.getY());
    }
}

