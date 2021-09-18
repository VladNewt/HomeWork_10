package base;

import base.types.Archer;
import base.types.Zombie;

public class Infected {
    public static final short ZOMBIE = 1;
    public static final short VAMPIR = 2;
    public static final short PARALYSIS = 3;
    public static final short VERWOLF = 4;

    private short typeInfection;
    private Hero hero;

    public Infected(short typeInfection, Hero hero) {
        this.typeInfection=typeInfection;
        this.hero = hero;
    }

    public boolean attackOF() {
        return false;
    }

    public Zombie createZombie() {
        hero.setAlive(false);
        return new Zombie(hero.getName());
    }



}
