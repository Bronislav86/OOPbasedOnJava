package ООП.Seminar1.Megicains;

public class Monk extends Wizzards {

    public Monk(String name, Integer x, Integer y) {
    super(name, x, y);

    }

    public String getInfo() {
        return "Монах";
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Да балгослословит Господь врагов моих. Аминь!..");
        }        
    }

}
