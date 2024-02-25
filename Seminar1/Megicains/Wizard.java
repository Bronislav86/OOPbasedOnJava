package ООП.Seminar1.Megicains;

import java.util.List;

import  ООП.Seminar1.BaseCharacter;

public class Wizard extends Wizzards implements MagicAttac {
    protected int mana;

    public Wizard(String name, Integer x, Integer y) {
        super(name, x, y);
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Бегите, глупцы!..");
        }        
    }

    


}
