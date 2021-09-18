package base.specialty;

import base.Hero;
import base.Sword;

public abstract class Warior extends Hero {
    private short armor;
    private boolean paralysys = false;     //При атаках магов или нежити, воин может быть заражен и стать зомби, вампиром или оборотнем

    public static final short START_HP = 200;
    public static final short START_ATTACK_FORCE = 150;
    public static final short START_ARMOR = 100;

    public Warior(short hp, short attackForce) {
        super(hp, attackForce);
    }


    public void setArmor(short armor) {
        if(armor<0) {
            this.armor = 0;
        } else {
            this.armor = armor;
        }
    }


    public short getArmor() {
        return armor;
    }


    public boolean isParalysys() {
        return paralysys;
    }

    public void setParalysys(boolean paralysys) {
        this.paralysys = paralysys;
    }

    public void takeDamage(short attack) {
        if (getArmor()>attack) {
            this.setArmor((short) (this.getArmor()-attack));
        } else {
                this.setHp((short) (this.getHp()+this.getArmor()-attack));
        }
    }

    public void intoxication(int source) {
        //1-зелье оцепенения;
        //2-отравляющее зелье;
        switch (source) {
            case 1:
                this.setParalysys(true);
                break;
            case 2:
                this.setHp((short) (getHp()-20));
                break;
        }
    }

}
