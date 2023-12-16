package Gear;

import Person.Person;

public abstract class WearableGear {
    WearableGear(int power, boolean isBig){
        this.power = power;
        this.isBig = isBig;
    }

    public abstract boolean wear(Person target);
    public abstract boolean unwear(Person target);
    public int getPower() {
        return power;
    }

    public boolean isBig() {
        return isBig;
    }
    private final int power;
    private final boolean isBig;
}
