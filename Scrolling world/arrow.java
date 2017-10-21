import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class arrow extends ScrollActor
  {
    public void act() 
    {
      List Objects = getWorld().getObjects(Lumber.class);
        for(Object obj : Objects)
           {
               Actor act= (Actor)obj;
                setLocation(act.getX(),act.getY()-100);
            }
         turnTowards(Lumber.y1,Lumber.y2);
         setRotation(getRotation()+130);
    }    
}
