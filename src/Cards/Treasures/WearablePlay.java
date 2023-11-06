package Cards.Treasures;
import Person.Person;
public interface WearablePlay {
    void Wear(WearableTreasureCard wearable, Person target);
    void UnWear(WearableTreasureCard wearable, Person target);
}
