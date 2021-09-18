import base.Hero;
import base.Infected;
import base.Sword;
import base.specialty.Warior;
import base.types.*;

public class Main {
    public static void main(String[] args) {

        Potioner vadik = new Potioner("Vadik");
        Necromant nickita = new Necromant("Nickita");

            while (vadik.getAlive() && nickita.getAlive()) {
//                System.out.println(vadik.getName()+vadik.toString()+" Armor = "+vadik.getArmor());
                System.out.println(nickita.getName()+nickita.toString());
                nickita.attack(vadik);
                nickita.takeDamage(vadik.attack());

                if (nickita.getAttackForce()==0 && vadik.getAttackForce()==0){
                    System.out.println("Frendship is win!!!");
                    break;
                }
            }

//            if (vadik.getAlive() && !nickita.getAlive()) {
//                vadikWin++;
//            } else if (nickita.getAlive() && !vadik.getAlive()) {
//                nickitaWin++;
//            }
//
//            vadik.setAlive(true);
//            vadik.setAttackForce(Warior.START_ATTACK_FORCE);
//            vadik.setArmor(Warior.START_ARMOR);
//            vadik.setHp(Warior.START_HP);
//
//            nickita.setAlive(true);
//            nickita.setAttackForce(Warior.START_ATTACK_FORCE);
//            nickita.setArmor(Warior.START_ARMOR);
//            nickita.setHp(Warior.START_HP);








    }
}
