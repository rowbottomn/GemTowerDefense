import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TankEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankEnemy extends Enemy
{
    public TankEnemy(ArrayList<Waypoint> p){
    super(p);
    speed = 1;
    dmg = 50;
    hp = 115;
    /*next is the index of the path that it's going to travel to
    after each waypoint next increments by 1 to go to the next one. 
    If you set next to 10 then the mob will go to the 10th waypoint
    */
    next = 0;
    }
    
}
