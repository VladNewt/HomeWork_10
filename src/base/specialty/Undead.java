package base.specialty;

import base.Hero;

public abstract class Undead extends Hero {

    protected static final short START_HP = 100;
    protected static final short START_ATTACK_FORCE = 300;
    protected static final short MAX_INFECTED = 250;


    public Undead() {
        super(START_HP, START_ATTACK_FORCE);
    }

    public Undead(String name) {
        this();
        this.setName(name);
    }



    public short getInfected() {
        return infected;
    }

    public void setInfected(short infected) {
        this.infected = infected;
    }

    private short infected;





}
