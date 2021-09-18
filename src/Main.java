import base.Hero;
import base.Infected;
import base.Sword;
import base.specialty.Warior;
import base.types.*;

public class Main {
    public static void main(String[] args) {

        Potioner vadik = new Potioner("Vadik");
        Necromant nickita = new Necromant("Nickita");



    }

    //Битва по умолчанию
    public void fight(Hero hero1, Hero hero2) {
        while (hero1.getAlive() && hero2.getAlive()) {
            System.out.println(hero1.getName()+hero1.toString());
            System.out.println(hero2.getName()+hero2.toString());
            hero1.takeDamage(hero2.attack());
            hero2.takeDamage(hero1.attack());

            if (hero1.getAttackForce()==0 && hero2.getAttackForce()==0){
                System.out.println("Frendship is win!!!");
                break;
            }
        }
    }
}
