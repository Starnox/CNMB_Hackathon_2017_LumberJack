import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class rotatie extends ScrollActor
{
    public static int rotation;
    public void act() 
    {
        List Objects = getWorld().getObjects(Lumber.class);
        for(Object obj : Objects)
           {
               Actor act= (Actor)obj;
                setLocation(act.getX(),act.getY());
            }
         turnTowards(Lumber.y1,Lumber.y2);
         rotation= getRotation()+180;
}
}
