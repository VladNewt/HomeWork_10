package base.types;

import base.Hero;
import base.specialty.Magie;

//Пироман - использует для атаки огонь, огонь отнимает жизнь, при этом не забирая броню(касается класса воинов)

public class Piromaniack extends Magie {

    private final short DEL_MANA=20;
    private final short DEL_ATTACK_FORCE=25;

    public Piromaniack() {

    }

    public Piromaniack(String name) {
        this.setName(name);
        this.setAttackForce(Magie.START_ATTACK_FORCE);
        this.setHp(Magie.START_HP);
        this.setMana(Magie.START_MANA);
    }

    //Здесь герой задается в методе attac, т.к. нужно принимать значение жизни героя и отнимать только жизнь
    public void attack(Hero hero) {
        if (getMana()-DEL_MANA>0 && getAttackForce()-DEL_ATTACK_FORCE>0) {
            this.setMana((short) (getMana()-DEL_MANA));
            this.setAttackForce((short) (getAttackForce()-DEL_ATTACK_FORCE));
            hero.setHp((short) (hero.getHp()-rnd.nextInt(DEL_MANA+DEL_ATTACK_FORCE)));
        }
    }
}
