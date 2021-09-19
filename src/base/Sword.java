package base;

import java.util.Random;

public class Sword {
    public static final short longSword = 1;
    public static final short shortSword = 2;

    private String name;            //тип меча длинный/короткий (long/short)
    private short deltaAttac;
    private short deltaDemage;

    public Sword(short type) {
        setSword(type);
    }

    //Выбор меча
    public void setSword(short type) {
        switch (type) {
            case 1:
                this.name = "Long";
                this.deltaAttac = 14;
                this.deltaDemage = 21;
                break;

            case 2:
                this.name = "Short";
                this.deltaAttac = 8;
                this.deltaDemage = 14;
                break;
        }
    }

    public short getDeltaAttac() {
        return deltaAttac;
    }

    public short getDeltaDemage() {
        return deltaDemage;
    }

    @Override
    public String toString() {
        return name;
    }
}
