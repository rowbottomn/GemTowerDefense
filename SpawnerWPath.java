import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Mr R Changed to Waypoint ArrayList and how waypoints are added to world
 * 
 * @author Rowbottom
 * @version Jan 15 2024
 */
public class SpawnerWPath extends Spawner
{
    private Game game;
    
    private ArrayList<Waypoint> path;//the path as generated from a text file
    
    private ArrayList<Enemy> waves = new ArrayList<Enemy>();//a arraylist of basic enemies
    

    
    String fileName;//the file of the waypoints
    
    int[][] wave = new int[10][2];//the coordinates of the 
    
    int levelNum = 1;
    int waveNum = 1;
    
    public SpawnerWPath(){
        path = new ArrayList<Waypoint>();
        fileName = "waypoints.txt";
        //create the wave timer
        waveTimer = new SimpleTimer();
        //create the spawn timer
        spawnTimer = new SimpleTimer();
        spawnTime = 5000;//initial time before wave
        waveTime = 0;
        
    }
    
    public SpawnerWPath(String fileName){
        this();
        this.fileName = fileName;
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
            
        //Use the array manager to turn the string into a 2D int array
        int[][] intArr = am.fillArrayWithData(tempString);
            //print out the int array to make sure it worked
        if(game.DEBUG){
            am.printArray(intArr);
            System.out.println(tempString);
        }
        //use a loop to add in all the waypoints in the int array
        for(int i = 0; i < intArr.length; i++){
            path.add(new Waypoint(this,intArr[i][0],intArr[i][1] ));
        }

    }
    
    public ArrayList<Waypoint> getPath(){
        return path;
    }
    
    
    public void addedToWorld(World world){
        game = (Game)world;
        setPath(fileName);
        loadWave();
        //add the waypoints in the path to the world
        for(Waypoint w:path){
            if(w != null){
                world.addObject(w, 0, 0);
            }
        }
        //get last waypoint
        Waypoint last = path.get(path.size()-1);
        
        //add the base object from the world
        game.addObject(game.getBase(),last.getX()+90,last.getY()-30);
        
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
