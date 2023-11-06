package Cards;

import Cards.Monster.MonsterProvider;

public class DeckManager {
    public DeckManager() {
        door_deck = new Deck();
        door_deck.addDeckProvider(new MonsterProvider());

        treasure_deck = new Deck();
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
