package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Doors.Monster.Monster;
import Cards.Treasures.OneTimePlayCards.OneTimePlay;
import Cards.Treasures.OneTimePlayCards.OneTimeTreasureCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

public class OneTimeTreasureCardsProvider implements Deck.Provider {
    public ArrayList<Card> GetCards() {

        ArrayList<Card> cards = new ArrayList<>();

        OneTimeTreasureCard magic_rocket = new OneTimeTreasureCard("Ракета магического назначения", 300, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                target.ChangeAdditionalPower(5);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                target.ChangeAdditionalPower(-5);
                return true;
            }
        });
        cards.add(magic_rocket);

        OneTimeTreasureCard enlightenment = new OneTimeTreasureCard("Достигни просветления", 0, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                 Log.fmtGlobLog("Играю %s\n", card.getName());
                if (!(target instanceof Person)){
                    Log.fmtGlobLog(Level.SEVERE, "Попытка сыграть %s не на персонажа\n", card.getName());
                    return false;
                }
                ((Person) target).increaseLevel(1);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                if (!(target instanceof Person)){
                    Log.fmtGlobLog(Level.SEVERE, "Попытка уйти %s не с персонажа\n", card.getName());
                    return false;
                }
                ((Person) target).decreaseLevel(1);
                return true;
            }
        });
        cards.add(enlightenment);

        OneTimeTreasureCard snow_potion = new OneTimeTreasureCard("Снежное зелье", 300, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                target.ChangeAdditionalPower(3);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                target.ChangeAdditionalPower(-3);
                return true;
            }
        });
        cards.add(snow_potion);

        OneTimeTreasureCard rotten_potion = new OneTimeTreasureCard("Вонючее зелье", 400, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                target.ChangeAdditionalPower(5);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                target.ChangeAdditionalPower(-5);
                return true;
            }
        });
        cards.add(rotten_potion);

        OneTimeTreasureCard protein = new OneTimeTreasureCard("Противный протеин", 200, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                target.ChangeAdditionalPower(2);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                target.ChangeAdditionalPower(-2);
                return true;
            }
        });
        cards.add(protein);

        OneTimeTreasureCard monster_deleter = new OneTimeTreasureCard("Зелье ослабления", 1000, new OneTimePlay() {
            @Override
            public boolean Play( OneTimeTreasureCard card,  Selectable target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                if (!(target instanceof Person)){
                    Log.fmtGlobLog(Level.SEVERE, "Попытка сыграть %s не на монстра\n", card.getName());
                    return false;
                }
                target.ChangeAdditionalPower(-target.GetPower());
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                target.ChangeAdditionalPower(20);
                return true;
            }
        });
        cards.add(protein);

        return cards;
    }
}
