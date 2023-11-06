import java.util.ArrayList;
import java.util.List;

public class WearableTreasureCardsProvider {
    static public List<WearableTreasureCard> getAllOneTimeCards() {
        List<WearableTreasureCard> cards = new ArrayList<>();

        WearableTreasureCard tights = new ArmorWearableTreasureCard(ArmorWearableTreasureCard.Slot.Other, "Колготы великанской силы", 600, false, 3);
        tights.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person2 target) {
                if (target.my_class == Person2.Class.warrior) {
                    return;
                }
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person2 target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(tights);

        WeaponWearableTreasureCard cheese = new WeaponWearableTreasureCard(WeaponWearableTreasureCard.Slot.OneHand, "Сыротерка умиротворения", 400, false, 3);
        cheese.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person2 target) {
                if (target.my_class != Person2.Class.cleric) {
                    return;
                }
                ((WeaponWearableTreasureCard) wearable).addWeapon(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person2 target) {
                ((WeaponWearableTreasureCard) wearable).removeWeapon(target);
            }
        });
        cards.add(cheese);

        ArmorWearableTreasureCard bandana = new ArmorWearableTreasureCard(ArmorWearableTreasureCard.Slot.Helmet, "Бандана сволочизма", 400, false, 3);
        bandana.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person2 target) {
                if (target.my_race != Person2.Race.human) {
                    return;
                }
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person2 target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(bandana);

        ArmorWearableTreasureCard leather_armor = new ArmorWearableTreasureCard(ArmorWearableTreasureCard.Slot.Body, "Кожаный прикид", 200, false, 1);
        leather_armor.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person2 target) {
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person2 target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(leather_armor);

        return cards;
    }
}
