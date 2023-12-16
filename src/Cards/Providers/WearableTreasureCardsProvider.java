package Cards.Providers;

import java.util.ArrayList;

import Cards.Card;
import Cards.Deck;
import Cards.Treasures.WearableCards.WearablePlay;
import Cards.Treasures.WearableCards.WearableTreasureCard;
import Gear.ArmorGear;
import Gear.WeaponGear;
import Gear.WearableGear;
import Person.Person;
import Loggers.Log;

public class WearableTreasureCardsProvider implements Deck.Provider {
    public ArrayList<Card> GetCards() {
        ArrayList<Card> cards = new ArrayList<>();

        WearableTreasureCard tights = new WearableTreasureCard("Колготы великанской силы", 600, new ArmorGear(3, false, ArmorGear.Slot.Other));
        tights.setPlay(new WearablePlay() {
            @Override
            public boolean WearWithCheck(WearableGear wearable, Person target) {
                if (target.getCurClass() == Person.Class.warrior) {
                    Log.fmtGlobLog("ТЫ ВОИН АХАХАХАХАХАХ");
                    return false;
                }
                return wearable.wear(target);
            }

            @Override
            public boolean UnWearWithCheck(WearableGear wearable, Person target) {
                return wearable.unwear(target);
            }
        });
        tights.Play(null);
        cards.add(tights);

        WearableTreasureCard cheese = new WearableTreasureCard("Сыротерка умиротворения", 400, new WeaponGear(3, false, WeaponGear.Size.OneHand));
        cheese.setPlay(new WearablePlay() {
            @Override
            public boolean WearWithCheck(WearableGear wearable, Person target) {
                if (target.getCurClass() != Person.Class.cleric) {
                    Log.fmtGlobLog("ТЫ ДАЖЕ НЕ КЛЕРИК");
                    return false;
                }
                return wearable.wear(target);
            }

            @Override
            public boolean UnWearWithCheck(WearableGear wearable, Person target) {
                return wearable.unwear(target);
            }
        });
        cards.add(cheese);

        WearableTreasureCard bandana = new WearableTreasureCard("Бандана сволочизма", 400, new ArmorGear(3, false, ArmorGear.Slot.Helmet));
        bandana.setPlay(new WearablePlay() {
            @Override
            public boolean WearWithCheck(WearableGear wearable, Person target) {
                if (target.getRace() != Person.Race.human) {
                    Log.fmtGlobLog("ТЫ ДАЖЕ НЕ ЧЕЛОВЕК");
                    return false;
                }
                return wearable.wear(target);
            }

            @Override
            public boolean UnWearWithCheck(WearableGear wearable, Person target) {
                return wearable.unwear(target);
            }
        });
        cards.add(bandana);

        WearableTreasureCard leather_armor = new WearableTreasureCard("Кожаный прикид", 200, new ArmorGear(1, false, ArmorGear.Slot.Body));
        cards.add(leather_armor);

        WearableTreasureCard fast_boots = new WearableTreasureCard("Ботинки быстрого бега", 400, new ArmorGear(3, false, ArmorGear.Slot.Legs));
        fast_boots.setPlay(new WearablePlay() {
            @Override
            public boolean WearWithCheck(WearableGear wearable, Person target) {
                target.changeRunAwayBonus(2);
                return wearable.wear(target);
            }

            @Override
            public boolean UnWearWithCheck(WearableGear wearable, Person target) {
                target.changeRunAwayBonus(-2);
                return wearable.unwear(target);
            }
        });
        cards.add(fast_boots);

        WearableTreasureCard morgen_cat = new WearableTreasureCard("Морген-кот", 400, new WeaponGear(3, false, WeaponGear.Size.OneHand));
        cards.add(morgen_cat);

        WearableTreasureCard knees = new WearableTreasureCard("Шипастые коленки", 200, new ArmorGear(1, false, ArmorGear.Slot.Other));
        cards.add(knees);

        WearableTreasureCard kitty_mittens = new WearableTreasureCard("Котявые варежки", 300, new ArmorGear(2, false, ArmorGear.Slot.Other));
        cards.add(kitty_mittens);

        WearableTreasureCard sing_sword = new WearableTreasureCard("Поющий меч", 200, new WeaponGear(2, false, WeaponGear.Size.OneHand));
        sing_sword.setPlay(checkClass(Person.Class.thief, "вор"));

        return cards;
    }

    static private WearablePlay checkClass(Person.Class check_class, String class_name) {
        return new WearablePlay() {
            @Override
            public boolean WearWithCheck(WearableGear wearable, Person target) {
                if (target.getCurClass() != Person.Class.cleric) {
                    Log.fmtGlobLog("ТЫ ДАЖЕ НЕ %s", class_name);
                    return false;
                }
                wearable.wear(target);
                return true;
            }

            @Override
            public boolean UnWearWithCheck(WearableGear wearable, Person target) {
                if (target.getCurClass() != Person.Class.cleric) {
                    Log.fmtGlobLog("ТЫ ДАЖЕ НЕ %s", class_name);
                    return false;
                }
                wearable.unwear(target);
                return true;
            }
        };
    }
}

