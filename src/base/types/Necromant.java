package base.types;

import base.Hero;
import base.specialty.Magie;

public class Necromant extends Magie{
    //Некромант имеет слабую атаку, но если герой умирает, он превращает его в зомби, и он становиться частью его команды
    //он отнимает уровень здоровья (броня не помогает)

    private final short DEL_MANA=9;
    private final short DEL_ATTACK_FORCE=11;

    public Necromant() {}

    public Necromant(String name) {
        this.setName(name);
        this.setAttackForce(Magie.START_ATTACK_FORCE);
        this.setHp(Magie.START_HP);
        this.setMana(Magie.START_MANA);
    }

    public Zombie attack(Hero hero) {
        if (getMana()-DEL_MANA>0 || getAttackForce()-DEL_ATTACK_FORCE>0) {
            hero.setHp((short) (getHp()-(rnd.nextInt(DEL_MANA+3*DEL_ATTACK_FORCE))));
            this.setMana((short) (getMana()-DEL_MANA));
            this.setAttackForce((short) (getAttackForce()-DEL_ATTACK_FORCE));
            if (!hero.getAlive()) {
                System.out.println(hero.getName() + " transform to zombie.");
                return new Zombie(hero.getName());
            }
        }
        return null;
    }

}
