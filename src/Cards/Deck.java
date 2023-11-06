package Cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    public interface Provider {
        ArrayList<Card> GetCards();
    }

    public List<Card> GetCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (Provider deckProvider : providers) {
            cards.addAll(deckProvider.GetCards());
        }

        return cards;
    }

    public void addDeckProvider(Provider provider) {
        providers.add(provider);
    }

    private List<Provider> providers;
}
