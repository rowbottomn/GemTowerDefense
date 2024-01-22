import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class SpeedyENemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedyEnemy extends Enemy
{
    public SpeedyEnemy(ArrayList<Waypoint> p){
    super(p);
    speed = 6;
    dmg = 20;
    hp = 40;
    
    } 
}
