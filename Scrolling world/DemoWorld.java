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
    }
}