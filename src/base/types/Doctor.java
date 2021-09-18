package base.types;

import base.specialty.Magie;
import base.specialty.Warior;

public class Doctor extends Magie {
    //Доктор не может атаковать, его атака - это лечение, применяется только в командных играх

    private final short HEALTH_MAX_INCREASE = 40;

    public Doctor() {

    }

    public Doctor(String name) {
        this.setName(name);
        this.setAttackForce(Magie.START_ATTACK_FORCE);
        this.setHp(Magie.START_HP);
        this.setMana(Magie.START_MANA);
    }

    @Override
    public short attack() {
        short attack = (short) rnd.nextInt(this.getMana());
        this.setMana((short) (this.getMana()-attack));
        this.setAttackForce((short) (getAttackForce()-attack));
        return (short) (getAttackForce()>attack ? -attack : 0);
    }
}
