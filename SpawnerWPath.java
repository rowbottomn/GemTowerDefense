import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Mr R - Don't use this yet
 * 
 * @author Rowbottom
 * @version Jan 9 2024
 */
public class SpawnerWPath extends Spawner
{
    private Waypoint[] path;
    
    private ArrayList<Enemy> waves = new ArrayList<Enemy>();
    
    String fileName;
    
    int[][] wave = new int[10][2];
    
    int levelNum = 1;
    int waveNum = 1;
    
    public SpawnerWPath(){
        path = new Waypoint[50];
        //path = new ArrayList<Waypoint>();
        setPath("waypoints.txt");
        
        //create the wave timer
        waveTimer = new SimpleTimer();
        //create the spawn timer
        spawnTimer = new SimpleTimer();
        spawnTime = 5000;//initial time before wave
        waveTime = 0;
        loadWave();
    }
    
    public SpawnerWPath(String fileName){

        path = new Waypoint[50];
        //path = new ArrayList<Waypoint>();
        
        setPath(fileName);
        
        //create the wave timer
        waveTimer = new SimpleTimer();
        //create the spawn timer
        spawnTimer = new SimpleTimer();
        spawnTime = 5000;//initial time before wave
        waveTime = 0;
        loadWave();
    }
    
    /**
     * Act - do whatever the SpawnerWPath wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        if(waves.size()==0){
            spawnTime = 5000;
            if(getWorld().getObjects(Enemy.class).size() == 0 && spawnTimer.millisElapsed()>spawnTime){
                //waveTime = 2000;
                spawnTime = 10000;
                spawnTimer.mark();
                loadWave();    
            }
            
        }
        else if(spawnTimer.millisElapsed()>spawnTime){
          getWorld().addObject(waves.get(0), getX(), getY());
          waves.remove(0);
          spawnTime = wave[wave.length-waves.size()-1][1];
          spawnTimer.mark();
        }
        
    }
    
    private void setPath(String fileName){
        //Instaniate a file manager 
        FileManager fm = new FileManager(fileName);
        //Instaniate an array manager
        ArrayManager am = new ArrayManager();
        //Load the file into a string using the fileManager
        String tempString = fm.read(fileName);
            //Print out the string to make sure it works
            System.out.println(tempString);
        //Use the array manager to turn the string into a 2D int array
        int[][] intArr = am.fillArrayWithData(tempString);
            //print out the int array to make sure it worked
            am.printArray(intArr);
        //use a loop to add in all the waypoints in the int array
        for(int i = 0; i < intArr.length; i++){
            path[i] = new Waypoint(intArr[i][0],intArr[i][1] );
        }

        
    }
    
    public void addedToWorld(World world){
        //add the waypoints in the path to the world
        for(Waypoint w:path){
            if(w != null){
                world.addObject(w, 0, 0);
            }
        }
    }
    
    private void loadWave(){
        for(int i = 0; i < wave.length; i++){
            wave[i][0] = 1;//these store the time between next spawn
            wave[i][1] = 600;
            waves.add(new Enemy(path));//int from wave[i][0] should go into the constructor
        }
        wave[1][1] = 100;
        wave[8][1] = 1200;
        wave[9][1] = 5000;   //time to next wave  
    }
}
