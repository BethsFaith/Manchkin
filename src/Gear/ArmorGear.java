package Gear;

import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class ArmorGear extends WearableGear {
    public enum Slot {
        Helmet(0),
        Body(1),
        Legs(2),

        Other(3);

        Slot(int slot) {
            this.slot_num = slot;
        }

        public int getNum() {
            return slot_num;
        }

        final private int slot_num;
    }

    public ArmorGear(int power, boolean is_big, Slot slot) {
        super(power, is_big);
        this.slot = slot;
    }

    @Override
    public boolean wear(Person person) {
        if(person == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка надеть вещь на null");
            return false;
        }
        if (isBig()){
            if (person.isHaveBig()){
                return false;
            }
            person.setHaveBig(true);
        }
        switch (slot) {
            case Helmet -> {
                if (person.helmet != null) {
                    return false;
                } else
                    person.helmet = this;
            }
            case Body -> {
                if (person.body != null) {
                    return false;
                } else
                    person.body = this;
            }
            case Legs -> {
                if (person.legs != null) {
                    return false;
                } else
                    person.legs = this;
            }
            case Other -> person.others.add(this);
        }
        return true;
    }

    @Override
    public boolean unwear(Person person) {
        if(person == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка снять вещь с null");
            return false;
        }
        if (isBig()){
            person.setHaveBig(false);
        }
        switch (slot) {
            case Helmet -> person.helmet = null;
            case Body -> person.body = null;
            case Legs -> person.legs = null;
            case Other -> person.others.remove(this);
        }
        return true;
    }

    public Slot getSlot() {
        return slot;
    }

    final private Slot slot;
}
