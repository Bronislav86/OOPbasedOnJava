package ООП.Seminar1;

import java.util.ArrayList;
import java.util.List;

public class Position {
    protected Integer x, y;

        public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public List<Integer> getPosition (){
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        return list;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
 * @param position - координаты персонажа
 * @return - Возвращает расстояние до цели
 */

 public double getDistanse (BaseCharacter target) {
        double targetDistanse = Math.sqrt(Math.pow(this.getX() - target.position.getX(), 2)) + (Math.pow(this.getY() - target.position.getY(), 2));
    return targetDistanse;
}

public Position getDiff (Position targetPos) {
    Position diff = new Position(x - targetPos.getX(), y - targetPos.getY());
    return diff;
}

public boolean equals(Position target) {
    return x == target.getX() && y == target.getY(); 
}
  
}
