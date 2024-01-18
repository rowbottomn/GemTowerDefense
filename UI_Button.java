import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UI_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI_Button extends UI
{
    private boolean placementMode = false;
    
    public UI_Button(){
        
    }
    
    
    public void act(){
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("Cell clicked at: " + getX() + ", " + getY());
            addTowerToMouse();
        }

    }

    public void addTowerToMouse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null){
            
                getWorld().addObject(new Basic_Tower(), mouse.getX(), mouse.getY());
            
        }
    }

}