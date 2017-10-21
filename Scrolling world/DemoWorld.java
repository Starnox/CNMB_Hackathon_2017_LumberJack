import greenfoot.*;


public class DemoWorld extends ScrollWorld
{
    public DemoWorld()
    {
        super(800, 600, 1, 2000, 2000);

        prepare();
    }

    private void prepare()
    {

        lumber lumber = new lumber();
        addObject(lumber,400,300);
        addObject(new orizontal(),1000,150);
        addObject(new vertical(),200,1000);
        addObject(new orizontal(),1000,1850);
        addObject(new vertical(),1800,1000);
    }
}