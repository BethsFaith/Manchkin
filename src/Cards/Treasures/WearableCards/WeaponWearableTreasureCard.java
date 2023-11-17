package Cards.Treasures.WearableCards;
import Person.Person;
import Gear.WeaponGear;
public class WeaponWearableTreasureCard extends WearableTreasureCard {

    public WeaponWearableTreasureCard(String name, int price, WeaponGear gear) {
        super(name, price);
        this.gear = gear;
    }

    boolean addWeapon(Person person) {
        if (person.hand_size + gear.getSize().getNum() > 2)
            return false;

        person.weapons.add(gear);
        person.hand_size += gear.getSize().getNum();
        return true;
    }

    boolean removeWeapon(Person person) {
        person.weapons.remove(gear);
        person.hand_size -= gear.getSize().getNum();
        return true;
    }
    final private WeaponGear gear;
}
