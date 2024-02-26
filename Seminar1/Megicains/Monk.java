package ООП.Seminar1.Megicains;

import java.util.List;
import  ООП.Seminar1.BaseCharacter;
import ООП.Seminar1.Position;

public class Monk extends Wizzards {
    protected int faith;

    public Monk(String name, Integer x, Integer y) {
    super(name, x, y);

    }

    public void setFaith(int faith) {this.faith = faith;}

    public int getFaith() {return faith;}

    public String getInfo() {
        return "Монах";
    }

    public void toHeal (BaseCharacter target){
        int damage = r.nextInt(5, 16);
        setFaith(getFaith() - damage);
        target.GetDamage(damage * -1);
    }

    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Да балгослословит Господь врагов моих. Аминь!..");
        }        
    }

    @Override
    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {
        if (getHealth() <= 0) return;
            BaseCharacter unit = nearestEnemy(friends);
            if (position.getDistanse(unit) < 2) {
                toHeal(unit);
                return;
            }
            Position diff = this.position.getDiff(unit.position);
            Position currentPos = new Position(position.getX(), position.getY());
            if (Math.abs(diff.getX()) >  Math.abs(diff.getY())){
                position.setX(position.getX() + diff.getX() > 0 ? 1 : -1);
            } else position.setY(position.getY() + diff.getY() > 0 ? 1 : -1);
            targets.forEach(n -> {
                if (n.position.equals(position)) {
                    this.position = currentPos;
                }
            });
    }



}
