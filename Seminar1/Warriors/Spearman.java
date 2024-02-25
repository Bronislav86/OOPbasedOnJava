package ООП.Seminar1.Warriors;

import java.util.ArrayList;
import java.util.List;

import ООП.Seminar1.BaseCharacter;

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

    public void step(List<BaseCharacter> list) {
        
    }


}
