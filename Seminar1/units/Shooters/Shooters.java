package ООП.Seminar1.Units.Shooters;


import java.util.ArrayList;

import ООП.Seminar1.Units.BaseCharacter;
import ООП.Seminar1.Units.Peasant;

abstract public class Shooters extends BaseCharacter {

    public Shooters(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 3;
    }

    protected Integer arrows;
    
    public Shooters() {
    }

    public Integer getArrows() {return arrows;}

    public void setArrows(Integer arrows) {this.arrows = arrows;}    

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        target.GetDamage(damage);
    }

    @Override
    public String toString() {return name +  ", Hp: " + health + ", St: " + strength + ", Arrows: " + arrows;}

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {

        if (getHealth() <= 0 || getArrows() <= 0) return;
            attac(nearestEnemy(targets));
            for (BaseCharacter unit : friends) {
                if (unit.getInfo().equals("Фермер") && !((Peasant)unit).flag) {
                    ((Peasant)unit).flag = true;
                    arrows++;
                    return;
                }
            }
            arrows--;
    }
        
    
    
}
