import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The UI is used by the user to select tower to place on the map
 * and see the cash, gems and enemy kills.
 * 
 * @author (Benjamin Callaghan) 
 * @version (v1.00)
 */
public class UI extends Actor
{
    private int cash = 0;
    private int gems = 0;
    private int eKills = 0;
    
    public UI(){
        this.cash = cash;
        this.gems = gems;
        this.eKills = eKills;
    }
    
    
    public int getCash(){
        return cash;
    }
    
    
    public void setCash(int cashAmt){
        cash = cashAmt; 
    }
    
    
    public int getGems(){
        return gems;
    }
    
    
    public void setGems(int gemsAmt){
        gems = gemsAmt;
    }
    
    
    public int getKills(){
        return eKills;
    }
    
    
    public void setKills(int killsAmt){
        eKills = killsAmt;
    }
    
    
    
    public String toString(){
        return "Cash: " + cash + " " + "Gems: " + gems + " " + "Kills: " + eKills; 
    }
}
