package base.types;

import base.specialty.Warior;

public class Berserk extends Warior {

    //У берсерка есть уникальное свойство - это ярость, она позволяет усилить атаку, но
    //отнимает здоровье и запас сил атаки. Ярость появляется рандомно.

    private final short START_RAGE = 50;
    private final short KOEF_INCREASE_ATTACK = 2;
    private final short KOEF_DECREASE_HP = 3;

    private short rage;

    public Berserk(String name) {
        this.setName(name);
        this.setHp(Warior.START_HP);
        this.setAttackForce(Warior.START_ATTACK_FORCE);
        this.setArmor(Warior.START_ARMOR);
        this.setRage(START_RAGE);
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
            short baseAttac = (short) rnd.nextInt(35);
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


}
