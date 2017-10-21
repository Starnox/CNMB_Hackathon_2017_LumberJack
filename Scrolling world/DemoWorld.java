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
        addObject(new Lumber(),400,300);
        addObject(new orizontal(),1000,150);
        addObject(new vertical(),200,1000);
        addObject(new orizontal(),1000,1850);
        addObject(new vertical(),1800,1000);
        copac_3 copac_3 = new copac_3();
        addObject(copac_3,103,118);
        copac_3 copac_32 = new copac_3();
        addObject(copac_32,45,236);
        copac_3.setLocation(237,127);
        copac_32.setLocation(105,187);
        copac_3.setLocation(160,47);
        copac_32.setLocation(105,187);
        copac_32.setLocation(105,187);
        copac_32.setLocation(105,187);
        copac_32.setLocation(105,187);
        copac_32.setLocation(3,134);
        copac_3.setLocation(201,104);
        copac_32.setLocation(41,203);
        copac_3.setLocation(155,133);
        copac_32.setLocation(60,203);
        copac_3.setLocation(173,133);
        copilul1 copilul1 = new copilul1();
        addObject(copilul1,654,417);
        Galeata galeata = new Galeata();
        addObject(galeata,209,567);
    }
}