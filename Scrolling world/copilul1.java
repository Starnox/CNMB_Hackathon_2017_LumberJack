import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class copilul1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class copilul1 extends copil
{
int k;
        public void act() 
    {
        k++;
        if(k%30==0)
        setImage("copil1-2.png");
        if(k%30==20)
         setImage("copil1-1.png");
    }    
    }    

