package ООП.Lection1.Ex007;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
      
        // #region ex1 Demo

        // BaseHero hero3 = new Magician();
        // System.out.println(hero3.getInfo());

        // BaseHero hero4 = new Priest();
        // System.out.println(hero4.getInfo());

        // #endregion

        // #region ex2 Attack
        // System.out.println("------");
        // System.out.println(hero3.getInfo());
        // System.out.println(hero4.getInfo());

        // hero3.Attack(hero4);
        
        // hero4.Attack(hero3);
        // System.out.println(hero3.getInfo());
        // System.out.println(hero4.getInfo());

        // #endregion

        // #region Teams

        int teamCount = 10;
        Random rand = new Random();
        int magicianCount = 0;
        int priestCount = 0;
        int healCount = 0;
 

        List<BaseHero> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            if (rand.nextInt(2) == 0) {
                if (healCount <= 2) {
                    teams.add(new Priest());
                    priestCount++;
                    teams.add(new Healer());
                    healCount++; 
                } else {
                    teams.add(new Priest());
                    priestCount++;
                }                             
            }
            else{
                if (healCount <= 2) {
                    teams.add(new Magician());
                    magicianCount++;
                    teams.add(new Healer());
                    healCount++;
                }else {
                    teams.add(new Magician());
                    magicianCount++;
                }              
            }

            System.out.println(teams.get(i).getInfo());
        }
        System.out.println();
        System.out.printf("magicalCount: %d priestCount: %d healCount: %d \n\n", magicianCount, priestCount, healCount);
        
        System.out.println(teams.get(0).getInfo());
        System.out.println(teams.get(1).getInfo());

        teams.get(0).Attack(teams.get(1));
        System.out.println("----------------------");

        System.out.println(teams.get(0).getInfo());
        System.out.println(teams.get(1).getInfo());

        boolean isHealed = true;
        
        while (isHealed) {
            for (BaseHero unit : teams) {
                if (unit instanceof Healer) {
                    ((Healer)(unit)).toHeal(teams.get(1));
                    isHealed = false;
                }  
        }
        
        }

        System.out.println("----------------------");
        System.out.println(teams.get(1).getInfo());



        // #endregion

        // todo добавить ещё один класс и 
        // реализовать возможность лечения героев
    }
}