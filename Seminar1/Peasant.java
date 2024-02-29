package ООП.Seminar1;

import java.util.List;

import ООП.Seminar1.Shooters.Crossbowman;
import ООП.Seminar1.Shooters.Shooters;
import ООП.Seminar1.Shooters.Sniper;

public class Peasant extends BaseCharacter {
    int unity;
    int arrow;
    public boolean flag;

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public int getArrow() {
        return arrow;
    }

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.speed = 0;
        this.arrow = 5;
        this.flag = false;
    }

    public String getInfo() {
        return "Фермер";
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моя служба окончена, Господин...");
        }
    }

    

    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {
  
        if (getHealth() <= 0) return;
        flag = false;
            
    }


}
