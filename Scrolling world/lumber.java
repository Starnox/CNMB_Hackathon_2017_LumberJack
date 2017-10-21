import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class lumber extends ScrollActor
{
    String key;
    int anim=4;
    int animCycle=7;
    int lastKey;
    public void act() 
    {
        key=Greenfoot.getKey();
        keys();
    }
    
    void keys()
    {
        if(Greenfoot.isKeyDown("a"))
        {
           getWorld().setCameraDirection(0);
            animate_left();
            lastKey=4;
        }
        else
        if(Greenfoot.isKeyDown("s"))
        {
            getWorld().setCameraDirection(270);
            animate_down();
            lastKey=3;
        }
        else
        if(Greenfoot.isKeyDown("d"))
        {
            getWorld().setCameraDirection(180);
            animate_right();
            lastKey=3;
        }
        else
        if(Greenfoot.isKeyDown("w"))
        {
            getWorld().setCameraDirection(90);
            animate_up();
            lastKey=3;
        }
        else 
        {
            anim=4;
            if(lastKey==4)
                setImage("idles.png");
            if(lastKey==3)
                setImage("idle.png");
            if(lastKey==2)
                setImage("idles.png");
            if(lastKey==1)
                setImage("idle.png");
        }
        
    }
    
    void animate_left()
    {
        anim++;
        if(anim==animCycle)
            setImage("merss1.png");
        if(anim==2*animCycle)
            setImage("merss2.png");
        if(anim==3*animCycle)
            {
                setImage("merss3.png");
                anim=4;
            }
        setLocation(getX()-5,getY());
        if(getX()<=1600)
        getWorld().moveCamera(-5);
    }
    
    void animate_down()
    {
        anim++;
        if(anim==animCycle)
            setImage("mersf1.png");
        if(anim==2*animCycle)
            setImage("mersf2.png");
        if(anim==3*animCycle)
            {
                setImage("mersf3.png");
                anim=4;
            }
         
        setLocation(getX(),getY()+5);
        if(getY()>=300)
        getWorld().moveCamera(-5);
    }
    
     void animate_right()
    {
        anim++;
        if(anim==animCycle)
            setImage("merss1.png");
        if(anim==2*animCycle)
            setImage("merss2.png");
        if(anim==3*animCycle)
            {
                setImage("merss3.png");
                anim=4;
            }
        
        setLocation(getX()+5,getY());
        if(getX()>=400)
        getWorld().moveCamera(-5);
    }
    
     void animate_up()
    {
        anim++;
        if(anim==animCycle)
            setImage("mersf1.png");
        if(anim==2*animCycle)
            setImage("mersf2.png");
        if(anim==3*animCycle)
            {
                setImage("mersf3.png");
                anim=4;
            }
        setLocation(getX(),getY()-5);
        if(getY()<=1500)
        getWorld().moveCamera(-5);
    }
}
