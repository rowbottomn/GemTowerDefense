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
    private UI_Button[][] towerBoxs;
    private static final int towerBoxsNum = 4;
    public Label l1, l2, l3;
    
    public UI(){
        this.cash = cash;
        this.gems = gems;
        this.eKills = eKills;
        
        towerBoxs = new UI_Button[towerBoxsNum][towerBoxsNum];
        
        l1 = new Label("cash: " + cash, 30);
        l2 = new Label("gems: " + gems, 30);
        l3 = new Label("Enemy Kills: " + eKills, 30);
        
    }
    
    
    
    public void spawnTower(String type){
        int count = 0;
        if(type.equals("n")){
            new Basic_Tower();
        }
    }
    
    
    public void setUpGrid(){
        for(int i = 0; i < towerBoxs.length; i++){
            for(int j = 0; j < towerBoxs.length; j++){
                towerBoxs[i][j] = new UI_Button();
            }
        }
    }
    
    
    public UI_Button getButton(int row, int col){
        return towerBoxs[row][col];
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
