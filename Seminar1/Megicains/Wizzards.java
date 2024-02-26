package ООП.Seminar1.Megicains;

import java.util.List;
import ООП.Seminar1.BaseCharacter;
import ООП.Seminar1.Position;

abstract public class Wizzards extends BaseCharacter {

    public Wizzards(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 1;
    }

    public int getSpeed() {
        return speed;
    }

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        target.GetDamage(damage);
    }

    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {
                        
        if (getHealth() <= 0) return;
            BaseCharacter unit = nearestEnemy(targets);
            if (position.getDistanse(unit) < 2) {
                attac(unit);
                return;
            }
            Position diff = this.position.getDiff(unit.position);
            Position currentPos = new Position(position.getX(), position.getY());
            if (Math.abs(diff.getX()) >  Math.abs(diff.getY())){
                position.setX(position.getX() + diff.getX() > 0 ? 1 : -1);
            } else position.setY(position.getY() + diff.getY() > 0 ? 1 : -1);
            friends.forEach(n -> {
                if (n.position.equals(position)) {
                    this.position = currentPos;
                }
            });
    }
}
