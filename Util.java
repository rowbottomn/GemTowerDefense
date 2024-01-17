/**
 * Write a description of class Util here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util  
{
    public final static boolean DEBUG = false;
    
    public static void say(String msg){
        if(DEBUG){
            System.out.println(msg);
        }
    }
    
    public static int dist(int x1,int  y1,int  x2, int y2){
        double dx = x2 - x1;
        double dy = y2 - y1;
        return (int)Math.sqrt(dx*dx + dy*dy);
    }
}
