package Cards.Treasures.WearableCards;

import java.util.ArrayList;
import java.util.List;

import Gear.ArmorGear;
import Gear.WeaponGear;
import Person.Person;

public class WearableTreasureCardsProvider {
    static public List<WearableTreasureCard> getAllWearableCards() {
        List<WearableTreasureCard> cards = new ArrayList<>();

        WearableTreasureCard tights = new ArmorWearableTreasureCard("Колготы великанской силы", 600, new ArmorGear(3, false, ArmorGear.Slot.Other));
        tights.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person target) {
                System.out.printf("Надеваю %s\n", wearable.getName());
                if (target.getCur_class() == Person.Class.warrior) {
                    System.out.println("ТЫ ВОИН АХАХАХАХАХАХ");
                    return;
                }
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(tights);

        WeaponWearableTreasureCard cheese = new WeaponWearableTreasureCard("Сыротерка умиротворения", 400, new WeaponGear(3, false, WeaponGear.Size.OneHand));
        cheese.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person target) {
                System.out.printf("Надеваю %s\n", wearable.getName());
                if (target.getCur_class() != Person.Class.cleric) {
                    System.out.println("ТЫ ДАЖЕ НЕ КЛЕРИК");
                    return;
                }
                ((WeaponWearableTreasureCard) wearable).addWeapon(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person target) {
                ((WeaponWearableTreasureCard) wearable).removeWeapon(target);
            }
        });
        cards.add(cheese);

        ArmorWearableTreasureCard bandana = new ArmorWearableTreasureCard("Бандана сволочизма", 400, new ArmorGear(3, false, ArmorGear.Slot.Helmet));
        bandana.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person target) {
                System.out.printf("Надеваю %s\n", wearable.getName());
                if (target.getRace() != Person.Race.human) {
                    System.out.println("ТЫ ДАЖЕ НЕ ЧЕЛОВЕК");
                    return;
                }
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(bandana);

        ArmorWearableTreasureCard leather_armor = new ArmorWearableTreasureCard("Кожаный прикид", 200, new ArmorGear(1, false, ArmorGear.Slot.Body));
        leather_armor.setPlay(new WearablePlay() {
            @Override
            public void Wear(WearableTreasureCard wearable, Person target) {
                System.out.printf("Надеваю %s\n", wearable.getName());
                ((ArmorWearableTreasureCard) wearable).wearArmor(target);
            }

            @Override
            public void UnWear(WearableTreasureCard wearable, Person target) {
                ((ArmorWearableTreasureCard) wearable).unWearArmor(target);
            }
        });
        cards.add(leather_armor);

        return cards;
    }
}
