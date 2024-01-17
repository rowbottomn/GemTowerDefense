import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;//for the colors instead of java.AWT.*

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    protected GreenfootImage temp;
    protected Color color; 
    protected Enemy owner;
    protected int maxHealth;
    protected int size;
    protected int health;
    protected int red = 0, green = 0;
    
    public HealthBar(Enemy o){
        //healthFill = new GreenfootImage(20,5);  
        // color = Color(0, 255, 0);
        this.maxHealth = o.getHealth();
        owner = o;

    }
    
    public void act()
    {
                
        //check to see if our owner is gone
        if (owner == null){
            kys();
            return;
        }
        //check to see if the object is no longer in the world 
        //should not have to do this if the world specified the act order reasonably 
        //but...
        if (owner.getWorld() == null){
            kys();
            return;
        }
        
        //if we nade it this far then we have an owner and its in the world
        //so update the health
        update();
        
    }
    
     private void kys(){
        getWorld().removeObject(this);
        Util.say("hb removed");

    }
    
     public void update() 
    {
       try{ 

       //update health
       
       health = owner.getHealth();
              //if we are full health or dead then no update required
       if (health == maxHealth|| health <= 0){return;}
       
       //move the bar to the right spot
       setLocation(owner.getX(), owner.getY()-size);

       //update the color
       try{//not really needed anymore
          Util.say("hb color attempt"+health);
          red = (int)(120.+134.*(1. - ((double)health/(double)maxHealth)));
          green = (int)( 254. *((double)health/(double)maxHealth));
          color = new Color(red,green, 0);
       }
       catch(Exception e){
          //let me know if we divided by zero somehow
          System.out.println(""+red+" , "+green);
       }
       
       temp.setColor(color); 
       temp.fill();
       temp.scale(1+50*health/maxHealth, 8);
       setImage(temp);
       Util.say("hb updated"+this.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    public void addedToWorld(World world){
        
        size = owner.getImage().getHeight()/2;
        owner.getWorld().addObject(this, owner.getX(), owner.getY()-size); 
        temp = getImage();
        temp.clear();
        Util.say("hb added to world");
    }
}
