package base.types;

import base.specialty.Warior;

import java.util.Objects;

public class Archer extends Warior {

    private final short START_ARROWS=50;
    private final short DELTA_ATTACK = 20;

    private short arrows;

    public Archer() {
        super();
        this.setArrows(START_ARROWS);
    }
//
    public Archer(String name) {
        this();
        this.setName(name);
    }

    public short getArrows() {
        return arrows;
    }

    public void setArrows(short arrows) {
        if (arrows<0) {
            this.arrows = 0;
        } else {
            this.arrows = arrows;
        }
    }

    @Override
    public short attack() {
        if (this.getAttackForce()-DELTA_ATTACK>0 && this.getArrows()-1 <= 0) {
            this.setAttackForce((short) (getAttackForce()-DELTA_ATTACK));
            this.setArrows((short) (getArrows()-1));
            //Работает вероятность попадания, если он попал, то атака =10, если нет, то =0, при этом сила теряется
            return rnd.nextBoolean() ? DELTA_ATTACK : 0;
        } else {
            this.setAttackForce((short) 0);
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Archer{" +
                "arrows=" + arrows +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Archer archer = (Archer) o;
        return START_ARROWS == archer.START_ARROWS && DELTA_ATTACK == archer.DELTA_ATTACK && arrows == archer.arrows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), START_ARROWS, DELTA_ATTACK, arrows);
    }
}
