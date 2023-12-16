package Cards.Treasures.WearableCards;

import Gear.WearableGear;
import Person.Person;

public interface WearablePlay {
    boolean WearWithCheck( WearableGear wearable,  Person target);
    boolean UnWearWithCheck( WearableGear wearable,  Person target);
}
