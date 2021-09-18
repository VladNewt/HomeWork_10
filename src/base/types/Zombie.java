package base.types;

import base.Hero;
import base.specialty.Undead;

public class Zombie extends Undead {


    public Zombie() {
        super();
    }

    public Zombie(String name) {
        super();
        this.setName(name);
    }

    //Атака зомби случайна, но сразу на много единиц
    //В методе takeDemage если его героя убил зомби, то он превращается в зомби
    //В зомби могут превратиться только воины, остальных он просто убивает
    public Undead attackUndead() {
        return new Zombie();
    }





}
