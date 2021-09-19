import base.Hero;
import base.Infected;
import base.Sword;
import base.specialty.Magie;
import base.specialty.Warior;
import base.types.*;

public class Main {



    public static void main(String[] args) {

       Necromant vadik = new Necromant("Vadik");
       Paladin nickita = new Paladin("Nickita");

       fight(nickita, vadik);

    }


    //Битва по умолчанию
    public static void fight(Hero hero1, Hero hero2) {
            while (hero1.getAlive() && hero2.getAlive()) {
                System.out.println(hero1.getName()+hero1.toString());
                System.out.println(hero2.getName()+hero2.toString());
                System.out.println("----------------------------------------------------------------------------------------------------");
                hero1.takeDamage(hero2.attack());
                hero2.takeDamage(hero1.attack());

                if (hero1.getAttackForce()==0 && hero2.getAttackForce()==0){
                    System.out.println("Frendship is win!!!");
                    break;
                }
            }
    }

    //В битве участвует один маг и один воин
    public static void fight(Magie magie, Warior hero) {
        while (magie.getAlive() && hero.getAlive()) {
            System.out.println(magie.getName()+magie.toString());
            System.out.println(hero.getName()+hero.toString());
            System.out.println("----------------------------------------------------------------------------------------------------");
            magie.attack(hero);
            magie.takeDamage(hero.attack());

            if (magie.getAttackForce()==0 && hero.getAttackForce()==0){
                System.out.println("Frendship is win!!!");
                break;
            }
        }
    }
}
