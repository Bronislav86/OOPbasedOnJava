package ООП.Seminar1.Megicains;

import java.util.ArrayList;
import java.util.List;
import ООП.Seminar1.BaseCharacter;

abstract public class Wizzards extends BaseCharacter {
    protected int mana;
    protected int maxMana;
    protected boolean flag;

    public Wizzards(String name, int x, int y) {
        super(name, x, y);
        speed = 1;
        maxMana = mana = 5;
        flag = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        target.GetDamage(-damage);
    }


    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {
        if (getHealth() <= 0) return;
        ArrayList<BaseCharacter> list = new ArrayList<>(friends);
        int count = 0;
        list.sort((u1, u2) -> u1.getHealth() - u2.getHealth());
            
            for (BaseCharacter unit : list) {
                if (unit.isDead()) {
                    count += 1;
                }
            }
            if (count >= 3) {
                flag = true;
            }
            if (flag && mana == maxMana) {
                attac(list.getFirst());
                mana = 0;
                flag = false;
                return;
            } 
            
            if (flag) {
                mana++;
                return;
            }
            if (mana < 2) {
                mana++;
                return;
            }
            attac(list.getFirst());
            mana -=2;
            
    }
}
