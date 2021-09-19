package base.types;

import base.Hero;
import base.specialty.Magie;
import base.specialty.Undead;
import base.specialty.Warior;

import java.util.Objects;

public class Potioner extends Magie {

    private final short BASE_DELTAHEALTH = 15;


    //Зелевар - использует для атаки зелье оцепенения, и отравляющее зелье т.е. рандомно атакуется противник, если зелье сработало, то
    //противник теряет жизни и не может проводить следующую атаку это касается только воинов и нежити, на других магов его зелье не действует.
    //Если сработало только зелье оцепенения, то противник не проводит следующую атаку, если сработало только отравляющее зелье, то противник теряет жизни при атаке на него
    // и теряет жизни при ответной атаке. Если оба зелья сработали, то происходит и то и другое.


    public Potioner() {
        super();
    }

    public Potioner(String name) {
        this();
        this.setName(name);
    }

    @Override
    public void attack(Warior warior) {
        boolean intoxication = rnd.nextBoolean();
        boolean paralysys = rnd.nextBoolean();
        warior.setParalysys(paralysys);
        if (intoxication) {
            warior.setHp((short) (getHp()-BASE_DELTAHEALTH));
        }
    }

    public void attack(Magie magie) {
        if (rnd.nextBoolean()) {
           magie.setHp((short) (getHp()-BASE_DELTAHEALTH));
        }
    }

    //При атаке нежить зелевар наносит им двойной урон здоровью
    public void attack(Undead undead) {
        undead.setHp((short) (getHp()-2*BASE_DELTAHEALTH));
    }

    @Override
    public String toString() {
        return "Potioner{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Potioner potioner = (Potioner) o;
        return BASE_DELTAHEALTH == potioner.BASE_DELTAHEALTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), BASE_DELTAHEALTH);
    }
}
