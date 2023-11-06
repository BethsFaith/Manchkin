public class WeaponWearableTreasureCard extends WearableTreasureCard {
    public enum Slot {
        OneHand(1),
        TwoHand(2);

        Slot(int slot) {
            this.slot = slot;
        }

        public int getNum() {
            return slot;
        }

        final private int slot;

    }

    public WeaponWearableTreasureCard(Slot slot, String name, int price, boolean is_big, int power) {
        super(name, price, is_big, power);
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }

    boolean addWeapon(Person2 person) {
        if (person.hand_size + getSlot().getNum() > 2)
            return false;

        person.weapons.add(this);
        person.hand_size += getSlot().getNum();
        return true;
    }

    boolean removeWeapon(Person2 person) {
        person.weapons.remove(this);
        person.hand_size -= getSlot().getNum();
        return true;
    }

    final private Slot slot;
}
