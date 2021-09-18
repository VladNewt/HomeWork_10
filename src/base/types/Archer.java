package base.types;

import base.specialty.Warior;

public class Archer extends Warior {

    private final short START_ARROWS=50;
    private final short DELTA_ATTACK = 20;
    private short arrows;

    public Archer() {}

    public Archer(String name) {
        this.setName(name);
        this.setAttackForce(Warior.START_ATTACK_FORCE);
        this.setArrows(START_ARROWS);
        this.setHp(Warior.START_HP);
        this.setArmor(Warior.START_ARMOR);
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
        if (getAttackForce()-DELTA_ATTACK>0) {
            this.setAttackForce((short) (getAttackForce()-DELTA_ATTACK));
            this.setArrows((short) (getArrows()-1));
            //Работает вероятность попадания, если он попал, то атака =10, если нет, то =0, при этом сила теряется
            return rnd.nextBoolean() ? DELTA_ATTACK : 0;
        } else {
            this.setAttackForce((short) 0);
            return 0;
        }
    }
}
