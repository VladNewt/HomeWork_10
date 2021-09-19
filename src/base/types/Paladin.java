package base.types;

import base.Hero;
import base.Infected;
import base.Sword;
import base.specialty.Warior;

import java.util.Objects;

public final class Paladin extends Warior {

    //У паладина для атаки будет 2 разных меча - длинный, и короткий
    //длинный - наносит больше урона, но сильно снижает уровень атаки
    //короткий - наносит меньше урона, но незначительно снижает уровень атаки
    //Для этого создан дополнительный класс Sword

    private Sword sword;

    public Paladin() {
        super();
    }

    public Paladin(String name) {
        if (rnd.nextBoolean()) {
            this.setSword(new Sword(Sword.longSword));
        } else {
            this.setSword(new Sword(Sword.shortSword));
        }
        this.setName(name);
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    @Override
    public short attack() {
        if (!isParalysys()) {
            if (getAttackForce() - this.sword.getDeltaAttac() <= 0) {
                this.setAttackForce((short) 0);
                return (short) (0);
            } else {
                this.setAttackForce((short) (this.getAttackForce() - this.sword.getDeltaAttac()));
                return (short) (rnd.nextInt(35) + this.sword.getDeltaDemage());
            }
        } else {
            return 0;
        }
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

    @Override
    public String toString() {
        return "Paladin{" +
                "sword=" + sword.toString() + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Paladin paladin = (Paladin) o;
        return Objects.equals(sword, paladin.sword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sword);
    }
}
