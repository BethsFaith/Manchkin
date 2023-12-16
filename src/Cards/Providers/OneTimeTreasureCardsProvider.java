package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Treasures.OneTimePlayCards.OneTimePlay;
import Cards.Treasures.OneTimePlayCards.OneTimeTreasureCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.ArrayList;

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
                ((Person) target).increaseLevel(1);
                return true;
            }

            @Override
            public boolean Leave( OneTimeTreasureCard card,  Selectable target) {
                ((Person) target).decreaseLevel(1);
                return true;
            }
        });
        cards.add(enlightenment);

        return cards;
    }
}
