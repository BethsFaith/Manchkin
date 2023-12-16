package Cards;

import Cards.Providers.*;

public class DeckManager {
    public DeckManager() {
        door_deck = new Deck();
        door_deck.addDeckProvider(new MonsterProvider());
        door_deck.addDeckProvider(new CursesCardProvider());
        door_deck.addDeckProvider(new MonsterBuffsProvider());
        door_deck.addDeckProvider(new ClassesCardProvider());
        door_deck.addDeckProvider(new RacesCardProvider());

        door_deck.initCards();

        treasure_deck = new Deck();
        treasure_deck.addDeckProvider(new OneTimeTreasureCardsProvider());
        treasure_deck.addDeckProvider(new WearableTreasureCardsProvider());

        treasure_deck.initCards();
    }

    public Deck getDoorDeck() {
        return door_deck;
    }

    public Deck getTreasureDeck() {
        return treasure_deck;
    }

    private final Deck door_deck;
    private final Deck treasure_deck;
}
