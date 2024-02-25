package ООП.Seminar1.Shooters;


import java.util.List;
import java.util.Scanner;

import ООП.Seminar1.BaseCharacter;

abstract public class Shooters extends BaseCharacter implements ShootSkill {
    protected Integer arrows;
    
    public Integer getArrows() {return arrows;}

    public void setArrows(Integer arrows) {this.arrows = arrows;}

    public Shooters(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 3;
    }    

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        this.arrows--;
        target.GetDamage(damage);
    }

    public void step(List<BaseCharacter> list, List<BaseCharacter> friends) {

        if (!isDead() || getArrows() <= 0) return;
            attac(nearestEnemy(list));
            System.out.println(toString());

    }
        
    
    
}
