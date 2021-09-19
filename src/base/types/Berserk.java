package base.types;

import base.specialty.Warior;

import java.util.Objects;

public class Berserk extends Warior {

    //У берсерка есть уникальное свойство - это ярость, она позволяет усилить атаку, но
    //отнимает здоровье и запас сил атаки. Ярость появляется рандомно.

    private final short START_RAGE = 50;
    private final short KOEF_INCREASE_ATTACK = 2;
    private final short KOEF_DECREASE_HP = 3;

    private short rage;

    public Berserk() {//
        super();
        this.setRage(START_RAGE);
    }

    public Berserk(String name) {
        this();
        this.setName(name);
    }

    public short getRage() {
        return rage;
    }
    public void setRage(short rage) {
        this.rage = rage;
    }

    @Override
    public short attack() {
        if (rnd.nextBoolean()) {
            short rageAttac = (short) rnd.nextInt(this.getRage());
            short baseAttac = (short) rnd.nextInt(40);
            this.setRage((short) (this.getRage()-rageAttac));
            this.setHp((short) (getHp()-rageAttac*KOEF_DECREASE_HP));
            this.setAttackForce((short) (getAttackForce()-rageAttac*KOEF_DECREASE_HP));
            return (short) (getAttackForce()<baseAttac+rageAttac*KOEF_INCREASE_ATTACK ? 0 : rageAttac*KOEF_INCREASE_ATTACK);
        } else {
            short attack = (short) rnd.nextInt(35);
            this.setAttackForce((short) (getAttackForce()-attack));
            return (short) (getAttackForce()<attack ? 0 : attack);
        }
    }

    @Override
    public String toString() {
        return "Berserk{" +
                "rage=" + rage + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Berserk berserk = (Berserk) o;
        return START_RAGE == berserk.START_RAGE && KOEF_INCREASE_ATTACK == berserk.KOEF_INCREASE_ATTACK && KOEF_DECREASE_HP == berserk.KOEF_DECREASE_HP && rage == berserk.rage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), START_RAGE, KOEF_INCREASE_ATTACK, KOEF_DECREASE_HP, rage);
    }


}
