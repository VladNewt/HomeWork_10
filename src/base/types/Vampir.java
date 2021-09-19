package base.types;

import base.specialty.Magie;
import base.specialty.Undead;
import base.specialty.Warior;


//Класс описания вампира - при атаке вампира теряется сила атакуемого(attackForce) или мана и здоровье
public class Vampir extends Undead {

    private final short BASE_LOW_FORCE = 42;
    private final short BASE_LOW_MANA = 50;

    public Vampir() {
        super();
    }

    public Vampir(String name) {
        this();
        this.setName(name);
    }


    public short attack(Warior warior) {
        warior.setAttackForce((short) (getAttackForce()-BASE_LOW_FORCE));
        return BASE_ATTACK;
    }

    public short attack(Magie magie) {
        magie.setMana((short) (magie.getMana()-BASE_LOW_MANA));
        return BASE_ATTACK;
    }


}
