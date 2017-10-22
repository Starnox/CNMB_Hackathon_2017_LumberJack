import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Mesaj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mesaj extends Actor
{

    public Mesaj(String text) 
    {
        GreenfootImage gl= new greenfoot.GreenfootImage(100,30);
        gl.drawString(text,2,30);
        setImage(gl);
    }    
}
