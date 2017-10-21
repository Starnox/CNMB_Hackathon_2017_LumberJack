import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Lumber extends ScrollActor
{
    private String key;
    private String cheie;
    public static int timer;
    private int anim=4;
    private int animCycle=7;
    private int lastKey;
    private int timerMini=0;
    private int greseli,corecte;
    int spawn=0;
    private boolean galeataPressed = false;
    private boolean rockPressed = false;
    private boolean canPressBucket = true;
    
    
    public void act() 
    {
        key=Greenfoot.getKey();
        keys();
        checkMouse();
        
        if(galeataPressed && rockPressed){
            
        }
        timer++;
        if(spawn==0&&timer%500==0)
        copii();
    }
    
    void keys()
    {
        if(eLangaCopil()==0)
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
         else if(Greenfoot.isKeyDown("1"))
        {
            galeataPressed = true;
            
            if(!getWorld().getObjects(Galeata.class).isEmpty()){
            Actor actor = getWorld().getObjects(Galeata.class).get(0);
            canPressBucket = false;
            actor.setImage("galeata-2.png");
        }
        else 
        {
            anim=4;
            if(lastKey==4)
                setImage("lumberjack_stanga_idle.png");
            if(lastKey==3)
                setImage("lumberjack_spate_idle.png");
            if(lastKey==2)
                setImage("lumberjack_dreapta_idle.png");
            if(lastKey==1)
                setImage("lumberjack_fata_idle.png");
        }
           
          
        }
        
       }
       else
       {
           timerMini++;
           if(timerMini==1)
               greseli=0;
           if(timerMini%100==1)
           {
              if(timerMini!=1)
              {
                  sageata_rosu();
                  greseli++;
              }
               if(greseli==2)
               {
                   corecte=0;
                   greseli=0;
                   timerMini=0;
                   remove_sageata();
                   getWorld().setCameraLocation(400,350);
                   getWorld().addObject(new Lumber(),400,350);
                   getWorld().removeObject(this);
                   return;
                }
               add_sageata();
            }
       if(key!=null)
       if(cheie!=null)
       if(key.equals("left")||key.equals("right")||key.equals("up")||key.equals("down"))
       if(key.equals(cheie))
       {
           corecte++;
           timerMini=32;
           if(corecte==4)
           {
                   corecte=0;
                   greseli=0;
                   timerMini=0;
                   remove_sageata();
                   List Objects=getObjectsInRange(500,copil.class);
                    for(Object obj : Objects)
                    {
                       getWorld().removeObject((Actor)obj);
                    }
                    spawn=0;

            }
          else 
               add_sageata();
       }
       else
            {
           greseli++;
           timerMini=32;
           sageata_rosu();
              if(greseli==2)
               {
                   remove_sageata();
                   corecte=0;
                   greseli=0;
                   timerMini=0;
                   getWorld().setCameraLocation(400,350);
                   getWorld().addObject(new Lumber(),400,350);
                   getWorld().removeObject(this);
                   return;
                }
                else
             add_sageata();
            }
        }
    }
        
   
    void sageata_rosu()
    {
        int i=0;
        List Objects=getObjectsInRange(500,sageti.class);
                for(Object obj : Objects)
                        {
                            Actor act;
                            act=(Actor)obj;
                            if(obj instanceof st)
                            act.setImage("stanga-rosu.png");
                            if(obj instanceof dr)
                            act.setImage("dreapta-rosu.png");
                            if(obj instanceof sus)
                            act.setImage("sus-rosu.png");
                            if(obj instanceof jos)
                            act.setImage("jos-rosu.png");
                            i++;
                        }
    }
    
    void remove_sageata()
    {
        List Objects=getObjectsInRange(500,sageti.class);
                    for(Object obj : Objects)
                        {
                            getWorld().removeObject((Actor)obj);
                        }
    }
    
    void add_sageata()
    {
         int x=Greenfoot.getRandomNumber(3);
         int suma= 100*(greseli+corecte);
        if(x==1)
               {
                   getWorld().addObject(new st(),getWorld().getCameraX()+suma-300,getWorld().getCameraY()-50);
                   cheie="left";
                }
               if(x==2)
               {
                   getWorld().addObject(new dr(),getWorld().getCameraX()+suma-300,getWorld().getCameraY()-50);
                 cheie="right";
                }
               if(x==3)
               {
                   getWorld().addObject(new sus(),getWorld().getCameraX()+suma-300,getWorld().getCameraY()-50);
                 cheie="up";
                }
               if(x==0)
               {
                   getWorld().addObject(new jos(),getWorld().getCameraX()+suma-300,getWorld().getCameraY()-50);
                 cheie="down";
                }
    }
    
    void animate_left()
    {
        anim++;
        if(anim==animCycle)
            setImage("lumberjack_stanga_1.png");
        if(anim==2*animCycle)
            setImage("lumberjack_stanga_2.png");
        if(anim==3*animCycle)
            {
                setImage("lumberjack_stanga_3.png");
                anim=4;
            }
         if(getOneObjectAtOffset(-5,0,Poteci.class)!=null)
       {
        setLocation(getX()-5,getY());
        if(getOneIntersectingObject(orizontal.class)!=null||getOneIntersectingObject(vertical.class)==null)
        getWorld().moveCamera(-5);
    }
    }
    
    
    
     void animate_right()
    {
        anim++;
        if(anim==animCycle)
            setImage("lumberjack_dreapta_1.png");
        if(anim==2*animCycle)
            setImage("lumberjack_dreapta_2.png");
        if(anim==3*animCycle)
            {
                setImage("lumberjack_dreapta_3.png");
                anim=4;
            }
        if(getOneObjectAtOffset(5,0,Poteci.class)!=null)
        {
        setLocation(getX()+5,getY());
        if(getOneIntersectingObject(orizontal.class)!=null||getOneIntersectingObject(vertical.class)==null)
        getWorld().moveCamera(-5);
       }
    }
    
     void animate_up()
    {
        anim++;
        if(anim==animCycle)
            setImage("lumberjack_fata_1.png");
        if(anim==2*animCycle)
            setImage("lumberjack_fata_2.png");
        if(anim==3*animCycle)
            {
                setImage("lumberjack_fata_3.png");
                anim=4;
            }
         if(getOneObjectAtOffset(0,-5,Poteci.class)!=null)
        {
            setLocation(getX(),getY()-5);
        if(getOneIntersectingObject(vertical.class)!=null||getOneIntersectingObject(orizontal.class)==null)
        getWorld().moveCamera(-5);
    }
    }
    
    void animate_down()
    {
        anim++;
        if(anim==animCycle)
            setImage("lumberjack_spate_1.png");
        if(anim==2*animCycle)
            setImage("lumberjack_spate_2.png");
        if(anim==3*animCycle)
            {
                setImage("lumberjack_spate_3.png");
                anim=4;
            }
         if(getOneObjectAtOffset(0,5,Poteci.class)!=null)
       {
           setLocation(getX(),getY()+5);
        if(getOneIntersectingObject(vertical.class)!=null||getOneIntersectingObject(orizontal.class)==null)
        getWorld().moveCamera(-5);
    }
    }
    

    int eLangaCopil()
    {
        List Objects=getObjectsInRange(100,copil.class);
        for(Object obj : Objects)
        {
            return 1;
        }
        return 0;
    }
    
    public void checkMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            if(mouse.getButton() == 1 && Greenfoot.mouseClicked(null))
            {
                Actor actor = mouse.getActor();
                if(actor instanceof Galeata && canPressBucket){
                canPressBucket = false;
                galeataPressed = true;
                actor.setImage("galeata-2.png");
            }
            
            else if(actor instanceof Rock)
            {
                rockPressed = true;
            }
            else if(actor instanceof fantana)
            {
                canPressBucket = true;
                if(!getWorld().getObjects(Galeata.class).isEmpty()){
                    Actor bucket = getWorld().getObjects(Galeata.class).get(0);
                    bucket.setImage("galeata-1.png");
            }
        }
            
        
            if(galeataPressed && rockPressed && actor instanceof Rock)
            if(actor instanceof Fire)
            {
                rockPressed = true;
            }
            if(galeataPressed && rockPressed && actor instanceof Fire)
            {
                getWorld().removeObject(actor);
                galeataPressed = false;
                rockPressed = false;
            }
            }
        }
            
      }
    void copii()
    {
        int x=Greenfoot.getRandomNumber(4);
        if(x==0)
        {
            getWorld().addObject(new copilul1(),98,320);
            getWorld().addObject(new copilul2(),145,292);
            getWorld().addObject(new copilul3(),184,316);
        }
        if(x==1)
        {
        getWorld().addObject(new copilul1(),811,851);
        getWorld().addObject(new copilul2(),920,852);
        getWorld().addObject(new copilul3(),871,851);
        }
        if(x==3)
        {
            getWorld().addObject(new copilul1(),98,320);
            getWorld().addObject(new copilul2(),145,292);
            getWorld().addObject(new copilul3(),184,316);
        }
        if(x==4)
        {
            getWorld().addObject(new copilul1(),98,320);
            getWorld().addObject(new copilul2(),145,292);
            getWorld().addObject(new copilul3(),184,316);
        }
        spawn=1;
    }
}

