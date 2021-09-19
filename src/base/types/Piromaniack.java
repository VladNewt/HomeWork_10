package base.types;

import base.Hero;
import base.specialty.Magie;

import java.util.Objects;

//Пироман - использует для атаки огонь, огонь отнимает жизнь, при этом не забирая броню(касается класса воинов)

public class Piromaniack extends Magie {

    private final short DEL_MANA=20;
    private final short DEL_ATTACK_FORCE=25;

    public Piromaniack() {
        super();
    }

    public Piromaniack(String name) {
        this();
        this.setName(name);
    }

    //Здесь герой задается в методе attac, т.к. нужно принимать значение жизни героя и отнимать только жизнь
    public void attack(Hero hero) {
        if (getMana()-DEL_MANA>0 && getAttackForce()-DEL_ATTACK_FORCE>0) {
            this.setMana((short) (getMana()-DEL_MANA));
            this.setAttackForce((short) (getAttackForce()-DEL_ATTACK_FORCE));
            hero.setHp((short) (hero.getHp()-rnd.nextInt(DEL_MANA+DEL_ATTACK_FORCE)));
        }
    }

    @Override
    public String toString() {
        return "Piromaniack{" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Piromaniack that = (Piromaniack) o;
        return DEL_MANA == that.DEL_MANA && DEL_ATTACK_FORCE == that.DEL_ATTACK_FORCE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), DEL_MANA, DEL_ATTACK_FORCE);
    }
}
