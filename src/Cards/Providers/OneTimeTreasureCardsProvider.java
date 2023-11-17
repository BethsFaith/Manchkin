package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Treasures.OneTimePlayCards.OneTimePlay;
import Cards.Treasures.OneTimePlayCards.OneTimeTreasureCard;
import Common.Selectable;
import Person.Person;

import java.util.ArrayList;
import java.util.List;

public class OneTimeTreasureCardsProvider implements Deck.Provider {
    public ArrayList<Card> GetCards() {

        ArrayList<Card> cards = new ArrayList<>();

        OneTimeTreasureCard magic_rocket = new OneTimeTreasureCard("Ракета магического назначения", 300);
        magic_rocket.setPlay(new OneTimePlay() {
            @Override
            public void Play(OneTimeTreasureCard card, Selectable target) {
                System.out.printf("Играю %s\n", card.getName());
                target.changePower(5);
            }

            @Override
            public void Leave(OneTimeTreasureCard card, Selectable target) {
                target.changePower(-5);
            }
        });
        cards.add(magic_rocket);

        OneTimeTreasureCard enlightenment = new OneTimeTreasureCard("Достигни просветления", 0);
        enlightenment.setPlay(new OneTimePlay() {
            @Override
            public void Play(OneTimeTreasureCard card, Selectable target) {
                System.out.printf("Играю %s\n", card.getName());
                ((Person) target).increaseLevel(1);
            }

            @Override
            public void Leave(OneTimeTreasureCard card, Selectable target) {
                ((Person) target).decreaseLevel(1);
            }
        });
        cards.add(enlightenment);

        return cards;
    }
}
