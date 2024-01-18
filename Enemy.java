import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends AbstEnemy
{
    //private Waypoint [] path;
    private ArrayList<Waypoint> path;
    private int next;
    private int health = 25;
    private HealthBar hb;

    public Enemy(){
        //path = new Waypoint[]{new Waypoint(100,100)};
    }
    
    public Enemy(Waypoint [] p){
        path = new ArrayList<Waypoint>();
        for (Waypoint w : p){
            path.add(w);
        }
        
        next = 0;
    }
    
    public Enemy(ArrayList<Waypoint> p){
        
        path = p;
        next = 0;
    }
    /*public Enemy(ArrayList <Waypoint> p){
        path = p;
        next = 0;
    } */ 
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(path.get(next)!=null){
            navigate(path.get(next).getX(), path.get(next).getY());
        }
        //navigate(path.get(next).getX(), path.get(next).getY());
        
    }
    
    public void navigate(){

    }
    
    public void navigate(int x, int y){
                //turn towards the target x y
        turnTowards(x, y);        
        //if not close to the target move 
        move(speed);
        //if I am close enough to the x, y
        if(dist(x,y)<speed ){
            next++;//go to the next waypoin

            if(next>=path.size()){

                //play explosion sound
                //make explosion
                //do damage to castle
                BaseObjective victim = (BaseObjective)getOneIntersectingObject(BaseObjective.class);
                if(victim !=null){
                    //getWorld().showText("Direct Hit", getWorld().getWidth()/2, 100);
                    //apply damage
                    victim.setHealth(victim.getHealth()-dam);
                    //remove bullet
                    getWorld().removeObject(this);
                    return;
                }
                
            }
        }
        if(health<1){
            getWorld().removeObject(this);
        }
    }
    
    private int dist(int x1, int y1){
        int dx = x1 - getX();
        int dy = y1 - getY();
        return (int)Math.sqrt(dx*dx+dy*dy);
    }
    
    public void addedToWorld(World world){
        hb = new HealthBar(this);
        world.addObject(hb, -1000,-1000);
        //does nto complete here
        Util.say(hb.toString());
        
    }
    
    public void setHealth(int h){
        health = h;
        Util.say("Enemy changing health "+health);

    }
    
    public int getHealth(){
        return health;
    }
}
