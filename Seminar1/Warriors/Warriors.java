package ООП.Seminar1.Warriors;

import java.util.List;
import java.util.Scanner;
import ООП.Seminar1.BaseCharacter;
import ООП.Seminar1.Position;

public abstract class Warriors extends BaseCharacter implements WarSkills {
    protected int anger;
    protected Position position;

    public Warriors(String name, Integer x, Integer y) {
        super(name, x, y);
        this.anger = 30;
        this.speed = 2;
        this.position = new Position(x, y);
    }

    public void attac(BaseCharacter target){
        int damage = r.nextInt(5, 15);
        this.anger--;
        target.GetDamage(damage);
    }
    
    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {

        if (!isDead()) return;
            BaseCharacter unit = nearestEnemy(targets);
            if (position.getDistanse(unit) < 2) {
                attac(unit);
                System.out.println(toString());
                return;
            }
            Position diff = this.position.getDiff(unit.position);
            Position currentPos = new Position(position.getX(), position.getY());
            if (Math.abs(diff.getX()) >  Math.abs(diff.getY())){
                position.setX(position.getX() + diff.getX() > 0 ? 1 : -1);
                System.out.println(toString());
            } else position.setY(position.getY() + diff.getY() > 0 ? 1 : -1);
            System.out.println(toString());

            friends.forEach(n -> {
                if (n.position.equals(position)) {
                    this.position = currentPos;
                }
            });
    }

}
