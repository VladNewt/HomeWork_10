package base.types;

import base.specialty.Undead;

//Класс описывающий оборотня атака оборотня случайна, но сильная
//при атаке у воинов уменьшается броня
public class Werwolf extends Undead {

    public Werwolf() {
        super();
    }

    public Werwolf(String name) {
        this();
        this.setName(name);
    }

    public short attack() {
        if(rnd.nextBoolean()) {
            return BASE_ATTACK+30;
        } else {
            return 0;
        }
    }

}
