package ООП.Seminar1.Shooters;

import java.util.List;

import ООП.Seminar1.BaseCharacter;

public class Crossbowman extends Shooters implements ShootSkill{

    public Crossbowman(String name, Integer x, Integer y) {
        super(name, x, y);
        this.arrows = 5;
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Мой арбалет больше никого не прикроет, прощай...");
        }
    }
       
    



    
}
