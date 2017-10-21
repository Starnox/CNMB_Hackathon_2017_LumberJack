import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class copilul3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class copilul2 extends copil
{
    /**
     * Act - do whatever the copilul3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int k;
    
    public void act() 
    {
        k++;
        if(k%30==0)
        setImage("copil2-2.png");
        if(k%30==20)
         setImage("copil2-1.png");
    }    
}
