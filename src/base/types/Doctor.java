package base.types;

import base.specialty.Magie;
import base.specialty.Warior;

import java.util.Objects;

public class Doctor extends Magie {
    //лекарь не может атаковать, его атака - это лечение, применяется только в командных играх

    private final short HEALTH_MAX_INCREASE = 40;

    public Doctor() {

    }

    public Doctor(String name) {
        super();
        this.setName(name);
    }

    @Override
    public short attack() {
        short attack = (short) rnd.nextInt(this.getMana());
        this.setMana((short) (this.getMana()-attack));
        this.setAttackForce((short) (getAttackForce()-attack));
        return (short) (getAttackForce()>attack ? -attack : 0);
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return HEALTH_MAX_INCREASE == doctor.HEALTH_MAX_INCREASE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), HEALTH_MAX_INCREASE);
    }
}
