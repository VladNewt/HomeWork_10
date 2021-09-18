package base.types;

import base.Hero;
import base.specialty.Magie;
import base.specialty.Undead;
import base.specialty.Warior;

public class Potioner extends Magie {

    private final short BASE_DELTAHEALTH = 15;


    //Зелевар - использует для атаки зелье оцепенения, и отравляющее зелье т.е. рандомно атакуется противник, если зелье сработало, то
    //противник теряет жизни и не может проводить следующую атаку это касается только воинов и нежити, на других магов его зелье не действует.
    //Если сработало только зелье оцепенения, то противник не проводит следующую атаку, если сработало только отравляющее зелье, то противник теряет жизни при атаке на него
    // и теряет жизни при ответной атаке. Если оба зелья сработали, то происходит и то и другое.


    public Potioner() {
    }

    public Potioner(String name) {
        super();
        this.setName(name);
    }

    public void attack(Warior warior) {
        boolean intoxication = rnd.nextBoolean();
        boolean paralysys = rnd.nextBoolean();
        warior.setParalysys(paralysys);
        if (intoxication) {
            this.setHp((short) (getHp()-BASE_DELTAHEALTH));
        }

    }

    public void attack(Magie magie) {
        if (rnd.nextBoolean()) {
           magie.setHp((short) (getHp()-BASE_DELTAHEALTH));
        }
    }

    public void attack(Undead undead) {
        undead.setHp((short) (getHp()-2*BASE_DELTAHEALTH));
    }

}
