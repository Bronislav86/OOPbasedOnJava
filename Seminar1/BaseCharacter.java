package ООП.Seminar1;

import java.util.List;
import java.util.Random;


public abstract class BaseCharacter implements Step{

    protected static Random r;

    protected int level;
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int stamina;
    protected Boolean status;
    protected int maxHealth;
    protected int speed;    
    public Position position;

    public List<BaseCharacter> units;

    static {BaseCharacter.r = new Random();    }

    public BaseCharacter(String name, int x, int y) {
        this.level = 1;
        this.name = name;
        this.health = 50;
        this.strength = 30;
        this.agility = 20;
        this.stamina = 30;
        this.maxHealth = health;
        this.speed = 3;
        this.status = true;
        this.position = new Position(x, y);
    }

    public String getName(){
        String str = new String(this.name);
        return str;
    }

    public int getSpeed() {return speed;}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public int getMaxHealth () {return maxHealth;}

    public int getStamina() {return stamina;}

    public String toString() {
        return name +  ", Hp: " + health + ", ⚔: ";
        //String.format("Class: %s  Name: %s hp: %s, Position %s", getClass().getSimpleName(), getName(), getHealth(), position.getPosition());
    }

    public Boolean getStatus() {return status;}
           
    public void GetDamage(int damage) {
        this.health -= damage;
            if (health < 0) {
                health = 0;
                death();
            }
            if (health >= maxHealth) health = maxHealth;            
    }

    public void death(){
        if (getHealth() < 1) {
            System.out.println("Ваш персонаж мертв");
        }
    }
/**
 * @return Этот метод сообщает Имя, Уровень здоровья, Координаты и Статус персонажа
 */
    public String getInfo() {
        return "";
    }

    public BaseCharacter nearestEnemy (List<BaseCharacter> targets) {
        BaseCharacter target = null;
        double minDistance = Double.MAX_VALUE;
        for (BaseCharacter hero : targets) {
            if (position.getDistanse(hero) < minDistance && hero.isDead()) {
                minDistance = position.getDistanse(hero);
                target = hero;                    
            }
        }
        return target;
    }

    public void getHealing (int heal){
        if (this.health < maxHealth) {
            if (this.health + heal > maxHealth) {
                this.health = maxHealth;
            }else {
                this.health += heal;
            }
            
        }
    }

    public boolean isDead(){
        if (this.getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public void attac(BaseCharacter target) {    }
}