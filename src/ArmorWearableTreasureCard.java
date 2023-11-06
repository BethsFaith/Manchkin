public class ArmorWearableTreasureCard extends WearableTreasureCard {
    public enum Slot {
        Helmet(0),
        Body(1),
        Legs(2),

        Other(3);

        Slot(int slot) {
            this.slot = slot;
        }

        public int getSlot() {
            return slot;
        }

        final private int slot;
    }

    public ArmorWearableTreasureCard(Slot slot, String name, int price, boolean is_big, int power) {
        super(name, price, is_big, power);
        this.slot = slot;
    }

    boolean wearArmor(Person2 target) {
        switch (this.slot) {
            case Helmet -> {
                if (target.helmet != null) {
                    return false;
                } else
                    target.helmet = this;
            }
            case Body -> {
                if (target.body != null) {
                    return false;
                } else
                    target.body = this;
            }
            case Legs -> {
                if (target.legs != null) {
                    return false;
                } else
                    target.legs = this;
            }
            case Other -> target.others.add(this);
        }
        target.power += power;
        return true;
    }

    boolean unWearArmor(Person2 target) {
        switch (this.slot) {
            case Helmet -> target.helmet = null;
            case Body -> target.body = null;
            case Legs -> target.legs = null;
            case Other -> target.others.remove(this);
        }
        target.power -= power;
        return true;
    }

    public Slot getSlot() {
        return slot;
    }

    final private Slot slot;
}
