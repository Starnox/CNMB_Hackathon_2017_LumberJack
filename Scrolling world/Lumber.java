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
    private int spawn=0;
    private int time = 1500;
    private boolean galeataPressed = false;
    private boolean firePressed = false;
    private boolean canPressBucket = true;
    int night=0;
    Mesaj msg;
    GreenfootSound  back = new GreenfootSound("Background.mp3");
    GreenfootSound  pasi = new GreenfootSound("Pasi.mp3");
    umbra umb= new umbra();
    arrow sageata= new arrow();
    public static int y1=750,y2=750;
    public void act() 
    {
        pasi.setVolume(50);
        back.setVolume(25);
         back.playLoop();
        countTimeFire();
        key=Greenfoot.getKey();
        keys();
        checkMouse();
        timer++;
        if(timer==1)
            foc();
        if(night==0)
         noapte();
        umb.setLocation(getX(),getY());
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
            pasi.stop();
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
                   setLocation(400,350);
                   time=1500;
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
                    time=1500;
                    foc();
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
                   setLocation(400,350);
                   time=1500;
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
        pasi.play();
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
        pasi.play();
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
        pasi.play();
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
        pasi.play();
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
            else if(actor instanceof Fire)
            {
                firePressed = true;
            }
            else if(actor instanceof fantana)
            {
                canPressBucket = true;
                if(!getWorld().getObjects(Galeata.class).isEmpty()){
                    Actor bucket = getWorld().getObjects(Galeata.class).get(0);
                    bucket.setImage("galeata-1.png");
            }
        }
            
            if(actor instanceof Fire)
            {
                firePressed = true;
            }
            if(galeataPressed && firePressed && actor instanceof Fire)
            {
                time=1500;
                copii();
                getWorld().removeObject(actor);
                spawn = 0;
                galeataPressed = false;
                firePressed = false;
            }
            }
        }
            
      }
    void copii()
    {
        int x=Greenfoot.getRandomNumber(3);
        if(x==0)
        {
           y1=100;
           y2=300;
            getWorld().addObject(new copilul1(),150,320);
            getWorld().addObject(new copilul2(),145,272);
            getWorld().addObject(new copilul3(),184,316);
        }
        if(x==1)
        {
             y1=800;
           y2=850;
        getWorld().addObject(new copilul1(),811,851);
        getWorld().addObject(new copilul2(),920,852);
        getWorld().addObject(new copilul3(),871,851);
        }
        if(x==2)
        {
             y1=100;
           y2=300;
            getWorld().addObject(new copilul1(),1081,297);
            getWorld().addObject(new copilul2(),1147,271);
            getWorld().addObject(new copilul3(),1135,316);

        }
        if(x==3)
        {
             y1=100;
           y2=300;
            getWorld().addObject(new copilul1(),344,1228);
            getWorld().addObject(new copilul2(),382,1226);
            getWorld().addObject(new copilul3(),337,1224);

        }
        spawn=1;
    }
    void foc()
    {
           
         int x=Greenfoot.getRandomNumber(4);
        if(x==0)
            {
                y1=484;
                y2=88;
                getWorld().addObject(new Fire(),484,88);
            }
        if(x==1)
        {
                y1=693;
                y2=258;
            
         getWorld().addObject(new Fire(),693,258);
    }
        if(x==2)
        {
                y1=449;
                y2=554;
            
            getWorld().addObject(new Fire(),449,554);
        }
        if(x==3)
        {
                y1=101;
                y2=282;
            
             getWorld().addObject(new Fire(),101,282);
        }
            if(x==4)
            {
                y1=464;
                y2=527;
            
            getWorld().addObject(new Fire(),464,527);
        }
        spawn=1;
    }
    
    void countTimeFire()
    {
        time--;
        showTime();
        showTime2();
        if(time / 55 <= 0)
        {
            time=1500;
            getWorld().setCameraLocation(400,300);
                   setLocation(400,350);
                   return;
        }
    }
    
    void showTime2()
    {
        getWorld().showText("Ora: "+timer/3600+":" + timer/60 + ":" +timer%60,700,100);
    }
    
    void showTime()
    {
           getWorld().showText("Time: "+time/55 ,100,100);
    }
    void noapte()
    {
        if(timer/3600==0)
        
        {
        getWorld().addObject(umb,getX(),getY());
        night=1;
    }
    }
}

