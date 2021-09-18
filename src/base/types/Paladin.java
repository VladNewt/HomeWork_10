package base.types;

import base.Infected;
import base.Sword;
import base.specialty.Warior;

public final class Paladin extends Warior {

    //У паладина для атаки будет 2 разных меча - длинный, и короткий
    //длинный - наносит больше урона, но сильно снижает уровень атаки
    //короткий - наносит меньше урона, но незначительно снижает уровень атаки
    //Для этого создан дополнительный класс Sword

    public Paladin(String name) {
        this.setName(name);
        this.setHp(Warior.START_HP);
        this.setAttackForce(Warior.START_ATTACK_FORCE);
        this.setArmor(Warior.START_ARMOR);
    }




    public short attack(Sword sword, Infected infected) {
        if (!super.isParalysys()) {
            if (getAttackForce() - sword.getDeltaAttac() <= 0) {
                this.setAttackForce((short) 0);
                return (short) (0);
            } else {
                this.setAttackForce((short) (this.getAttackForce() - sword.getDeltaAttac()));
                return (short) (rnd.nextInt(35) + sword.getDeltaDemage());
            }
        }
        return 0;

    }



}
