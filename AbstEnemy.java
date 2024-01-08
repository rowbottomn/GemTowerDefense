    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class AbstEnemy here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public abstract class AbstEnemy extends Actor
    {
        protected int speed;
        protected int hp;
        protected Actor target;
        protected int dam;
        protected World world;
        protected GreenfootImage img;
        
        public AbstEnemy(){
            speed = 5;
            hp = 5;
            dam = 1;
            img = getImage();
        }
        
        public abstract void navigate();
        
        public abstract void navigate(int x, int y);
        
    }
