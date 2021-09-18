package base;

import java.util.Random;

public abstract class Hero {
    private String name;
    private short hp;
    private short attackForce;
    private boolean alive;

    public Random rnd = new Random();

    {
        alive = true;
    }

    public Hero(short hp, short attackForce) {
        this.hp = hp;
        this.attackForce = attackForce;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHp(short hp) {
        if (hp<0) {
            this.hp=0;
            this.alive=false;
            System.out.println("Hero "+this.name+" is die.");
        }
        this.hp = hp;
    }

    public void setAttackForce(short attackForce) {
        if (attackForce<=0) {
            this.attackForce=0;
        } else {
            this.attackForce = attackForce;
        }
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public short getHp() {
        return hp;
    }

    public short getAttackForce() {
        return attackForce;
    }


    public boolean getAlive() {
        return alive;
    }



    public short attack() {
        return 0;
    }
    public void takeDamage(short attack) {}


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attackForce=" + attackForce +
                ", alive=" + alive +
                '}';
    }
}
