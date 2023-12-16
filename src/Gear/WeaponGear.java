package Gear;

import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class WeaponGear extends WearableGear {
    public enum Size {
        OneHand(1),
        TwoHand(2);

        Size(int slot) {
            this.slot = slot;
        }

        public int getNum() {
            return slot;
        }

        final private int slot;

    }

    public WeaponGear(int power, boolean isBig, Size size) {
        super(power, isBig);
        this.size = size;
    }

    @Override
    public boolean wear(Person person) {
        if(person == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка надеть вещь на null");
            return false;
        }
        if (person.hand_size + this.getSize().getNum() > 2)
            return false;
        if (isBig()){
            if (person.isHaveBig()){
                return false;
            }
            person.setHaveBig(true);
        }

        person.weapons.add(this);
        person.hand_size += this.getSize().getNum();
        return true;
    }

    @Override
    public boolean unwear( Person person) {
        if(person == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка снять вещь с null");
            return false;
        }
        if (isBig()){
            person.setHaveBig(false);
        }
        person.weapons.remove(this);
        person.hand_size -= this.getSize().getNum();
        return true;
    }

    public Size getSize() {
        return size;
    }

    private final Size size;
}
