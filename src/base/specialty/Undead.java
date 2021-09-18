package base.specialty;

import base.Hero;

public abstract class Undead extends Hero {

    protected static final short START_HP = 100;
    protected static final short START_ATTACK_FORCE = 300;
    protected static final short MAX_INFECTED = 250;
    protected static final short BASE_ATTACK = 50;






    public Undead() {
        super(START_HP, START_ATTACK_FORCE);
        this.setInfected(MAX_INFECTED);
    }



    public short getInfected() {
        return infected;
    }

    public void setInfected(short infected) {
        this.infected = infected;
    }

    private short infected;


    public Undead attackUndead(){
        return null;
    }




}
