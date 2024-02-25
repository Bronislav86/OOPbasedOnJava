package ООП.Seminar1.Megicains;

import java.util.List;
import java.util.Scanner;

import  ООП.Seminar1.BaseCharacter;
import ООП.Seminar1.Position;

public class Monk extends Wizzards {
    protected int faith;

    public Monk(String name, Integer x, Integer y) {
    super(name, x, y);

    }

    public void setFaith(int faith) {this.faith = faith;}

    public int getFaith() {return faith;}

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

    public void step(List<BaseCharacter> targets, List<BaseCharacter> friends) {
        Scanner scan = new Scanner(System.in);
        String oneStep = scan.nextLine();
                
            if (oneStep == "") {
                        
                if (!isDead()) return;
                    BaseCharacter unit = nearestEnemy(friends);
                    if (position.getDistanse(unit) < 2) {
                        toHeal(unit);
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
                    targets.forEach(n -> {
                        if (n.position.equals(position)) {
                            this.position = currentPos;
                        }
                    });
            }else return;
    }



}
