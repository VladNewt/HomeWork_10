package base.types;

import base.Hero;
import base.specialty.Undead;

//Атака зомби случайна, но сразу уменьшает много много единиц здоровья

public class Zombie extends Undead {


    public Zombie() {
        super();
    }

    public Zombie(String name) {
        this();
        this.setName(name);
    }


    public short attack() {
        if(rnd.nextBoolean()) {
            this.setAttackForce((short) (getAttackForce()-BASE_ATTACK));
            return BASE_ATTACK;
        } else {
            return 0;
        }
    }





}
