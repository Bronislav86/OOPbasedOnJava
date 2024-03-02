package ООП.Seminar1.units.Warriors;

public class Spearman extends Warriors{
    protected int resistance;

    public Spearman(String name, Integer x, Integer y) {
        super(name, x, y);
    }   

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моё копье сломано... Я пал...");
        }
    }
    
    public String getInfo() {
        return "Копейщик";
    }


}
