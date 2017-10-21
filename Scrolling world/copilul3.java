import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class copilul3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class copilul3 extends copil
{
     int k;
    
    public void act() 
    {
        k++;
        if(k%30==0)
        setImage("copil3-2.png");
        if(k%30==20)
         setImage("copil3-1.png");
    }     
}
