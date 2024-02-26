package ООП.Seminar1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ООП.Seminar1.Megicains.Monk;
import ООП.Seminar1.Megicains.Wizard;
import ООП.Seminar1.Shooters.Crossbowman;
import ООП.Seminar1.Shooters.Sniper;
import ООП.Seminar1.Warriors.Raider;
import ООП.Seminar1.Warriors.Spearman;

/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
 */

/*Крестьянин:      Разбойник:              Копейщик:
 - Здоровье        - ID                    - ID
 - Сила            - Имя                   - Имя
 - Ловкость        - Здоровье              - Здоровье
 - Выносливость    - Сила                  - Сила
 - Вид оружия      - Ловкость              - Выносливость
 - Уровень         - Выносливость          - Вид оружия
 - ID              - Вид оружиня           - Защита
 - Имя             

 Снайпер           Арбалетчик:             Колдун:             Монах:
 - ID              - ID                    - ID                - ID
 - Имя             - Имя                   - Имя               - Имя
 - Здоровье        - Здоровье              - Здоровье          - Здоровье
 - Сила            - Выносливость          - Интеллект         - Выносливость
 - Ловкость        - Вид оружия            - Выносливость      - Вид оружия
 - Выносливость    - Меткость              - Вид оружия        - Интеллект
 - Вид оружия      - Количество стрел      - Мана              - Вера
 - Меткость        - Скорость стрельбы                         - Чакра
 - Маскировка      

 Семинар 3:
 Добавить в файл интерфейса метод void step() это будет основной метод взаимодействыия с объектами.
 Добавить интерфейс в базовый абстрактный класс. Реализовать этот метод во всех классах наследниках.
 Для начала просто заглушкой.

 Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет
 то завершить метод. Есль всё да, то найти ближайшего противника и выстрелить по немы и, соответственно
 потратить одну стрелу. Реализовать весь функционал лучников в методе step().

 Добавить в абстрактный класс int поле инициатива. В классах наследников инициализировать это поле.
 Крестьянин = 0, маги=1, пехота=2, лучники=3. В мэйне сделать так, чтобы сначала делали ход персонажи с наивысшей
 инициативой из обеих команд а с наименьшей в конце.

 Семинар 4:
 Реализовать метод step() пехоты. Первое проверяем живы ли мы, потом ищем ближайшего противника. Если противник в
 соседней клетке, наносим повреждение. Иначе двигаемся в сторну противника. Алгоритм движения, если dX>dY двигаемся
 по x иначе по y. dX и dY (разница наших координат и ближайшего противника) знаковые, от знака зависит направление.
 По своим не ходить!

*/
public class Main {
    public static List<BaseCharacter> holyTeam = new ArrayList<>(teamCreator(1));
    public static List<BaseCharacter> darkTeam = new ArrayList<>(teamCreator(10));
    public static ArrayList<BaseCharacter> allTeam = new ArrayList<>();
    
    public static void main(String[] args) {
        
        System.out.println("Команда №1: ");
        for (BaseCharacter unit : holyTeam) {
            System.out.printf("Имя: %s, Класс: %s, Здоровье: %d, Координаты: %d,%d\n", unit.getName(),
                    unit.getClass().getSimpleName(), unit.getHealth(), unit.position.getX(), unit.position.getY());
        }

        System.out.println();

        System.out.println("Команда №2: ");
        for (BaseCharacter unit : darkTeam) {
            System.out.printf("Имя: %s, Класс: %s, Здоровье: %d, Координаты: %d,%d\n", unit.getName(),
                    unit.getClass().getSimpleName(), unit.getHealth(), unit.position.getX(), unit.position.getY());
        }

        System.out.println();

        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);

        allTeam.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());

        System.out.println("-".repeat(56));
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (true) {

            View.view();
            scanner.nextLine();
            int summ1HP = 0;
            int summ2HP = 0;
            for (BaseCharacter unit : holyTeam){
                summ1HP += unit.getHealth();
            }
            for (BaseCharacter unit : darkTeam){
                summ2HP += unit.getHealth();
            }
            if (summ1HP == 0){
                System.out.println("Победила команда darkTeam");
                flag = false;
                break;
            }
            if (summ2HP == 0){
                System.out.println("Победила команда holyTeam");
                flag = false;
                break;
            }
            for (BaseCharacter unit : allTeam) {
                if (holyTeam.contains(unit)) unit.step(darkTeam, holyTeam);
                else unit.step(holyTeam, darkTeam);
            }
            
        }
        scanner.close();
        
        

        // for (BaseCharacter unit : allTeam) {
        //     System.out.printf("Имя: %s, Здоровье: %d, Класс: %s, Координаты: %d,%d\n", unit.getName(), unit.getHealth(),
        //             unit.getClass().getSimpleName(), unit.position.getX(), unit.position.getY());
        // }




    }

    private static String fillName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    private static ArrayList<BaseCharacter> teamCreator(int y) {
        ArrayList<BaseCharacter> team = new ArrayList<BaseCharacter>();
        int teamCount = 10;
        for (int i = 1; i < teamCount+1; i++) {
            switch (new Random().nextInt(1, 8)) {
                case 1:
                    team.add(new Monk(fillName(), i, y));
                    break;
                case 2:
                    team.add(new Wizard(fillName(), i, y));
                    break;
                case 3:
                    team.add(new Crossbowman(fillName(), i, y));
                    break;
                case 4:
                    team.add(new Sniper(fillName(), i, y));
                    break;
                case 5:
                    team.add(new Peasant(fillName(), i, y));
                    break;
                case 6:
                    team.add(new Raider(fillName(), i, y));
                    break;
                case 7:
                    team.add(new Spearman(fillName(), i, y));
                    break;
            }
        }
        return team;
    }

    // @Override
    // public String toString() {
    //     return class().getSimpleName() + name;
    // }
}
