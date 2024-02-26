package ООП.Seminar1.Megicains;


public class Wizard extends Wizzards {
    protected int mana;

    public Wizard(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    public String getInfo() {
        return "Волшебник";
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Бегите, глупцы!..");
        }        
    }

    


}
