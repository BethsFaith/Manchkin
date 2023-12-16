package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Doors.Races.RaceCard;
import Person.Person;

import java.util.ArrayList;

public class RacesCardProvider implements Deck.Provider {
    @Override
    public ArrayList<Card> GetCards() {
        var cards = new ArrayList<Card>();

        cards.add(new RaceCard("Эльф", Person.Race.elf));
        cards.add(new RaceCard("Эльф", Person.Race.elf));
        cards.add(new RaceCard("Гном", Person.Race.dwarf));
        cards.add(new RaceCard("Гном", Person.Race.dwarf));
        cards.add(new RaceCard("Хоббитс", Person.Race.half_breed));
        cards.add(new RaceCard("Хоббитс", Person.Race.half_breed));
        cards.add(new RaceCard("Человек", Person.Race.human));
        cards.add(new RaceCard("Человек", Person.Race.human));
        cards.add(new RaceCard("Хафлинг", Person.Race.halfling));
        cards.add(new RaceCard("Хафлинг", Person.Race.halfling));

        return cards;
    }
}
