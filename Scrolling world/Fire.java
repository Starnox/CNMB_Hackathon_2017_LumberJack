import greenfoot.*;


public class Fire extends ScrollActor
{
     int k;
    
    public void act() 
    {
        k++;
        if(k%30==0)
        setImage("foc-2.png");
        if(k%30==20)
         setImage("foc-1.png");
    } 
}