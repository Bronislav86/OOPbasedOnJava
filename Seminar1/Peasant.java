package ООП.Seminar1;

import java.util.List;
import java.util.Scanner;

public class Peasant extends BaseCharacter {
    int unity;

    public Peasant(String name, Integer x, Integer y) {
        super(name, x, y);
        this.speed = 0;
    }

    public void work(int hour) {
        stamina -= hour / 4;
    }

    @Override
    public void death() {
        if (this.getHealth() < 1) {
            System.out.println("Моя служба окончена, Господин...");
        }
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
