package ООП.Seminar1.Units.Megicains;

import java.util.ArrayList;
import java.util.Iterator;

import ООП.Seminar1.Units.BaseCharacter;

public abstract class Wizzards extends BaseCharacter {
    protected int mana;
    protected int maxMana;
    protected boolean flag;

    public Wizzards() {
    }

    public Wizzards(String name, int x, int y) {
        super(name, x, y);
        speed = 1;
        maxMana = mana = 5;
        flag = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void attac(BaseCharacter target) {
        int damage = r.nextInt(5, 15);
        target.GetDamage(-damage);
    }

    public void step(ArrayList<BaseCharacter> targets, ArrayList<BaseCharacter> friends) {
        if (getHealth() <= 0)
            return;
        ArrayList<BaseCharacter> listForHeal = new ArrayList<BaseCharacter>(friends);
        ArrayList<BaseCharacter> listOfDeads = new ArrayList<BaseCharacter>();
        listForHeal.sort((u1, u2) -> u1.getHealth() - u2.getHealth());

        Iterator<BaseCharacter> iterator = listForHeal.iterator();
            while (iterator.hasNext()) {
                BaseCharacter unit = iterator.next();
                if (unit.isDead()) {
}                   listOfDeads.add(unit);
                    iterator.remove();
            }
        
        if (listOfDeads.size() > 3) {
            flag = true;
            //System.out.println("Флаг устанволен!");
        }
        if (flag && mana == maxMana) {
            listOfDeads.sort((u1, u2) -> u2.getSpeed() - u1.getSpeed());
            listOfDeads.get(0).setHealth(maxHealth/2);
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
        attac(listForHeal.get(0));
        mana -= 2;

    }

    @Override
    public String toString() {return name +  ", Hp: " + health + ", St: " + strength + ", Mana: " + mana;}


}
