package base.specialty;

import base.Hero;

public abstract class Magie extends Hero {
    //У магов больший запас здоровья, у них помимо запаса силы атаки имеется манна, без которой он неспособен атаковать
    //или лечить себя. Все маги обладают свойством восстановления здоровья

    public static final short START_HP = 160;
    public static final short START_ATTACK_FORCE = 100;
    public static final short START_MANA = 100;

    private short mana;

    public Magie() {
        super(START_HP, START_ATTACK_FORCE);
        this.setMana(Magie.START_MANA);
    }

    public short getMana() {
        return mana;
    }

    public void setMana(short mana) {
        if (mana<=0) {
            this.mana = 0;
        } else {
            this.mana = mana;
        }

    }

    public void takeDamage(short attack) {
        if (mana>=10 && this.getHp()<10) {
            this.setHp((short) 10);
        } else {
            this.setHp((short) (getHp() - attack));
        }
    }
}
