package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Doors.Classes.ClassCard;
import Person.Person;

import java.util.ArrayList;

public class ClassesCardProvider implements Deck.Provider{
    @Override
    public ArrayList<Card> GetCards() {
        var cards = new ArrayList<Card>();

        cards.add(new ClassCard("Клирик", Person.Class.cleric));
        cards.add(new ClassCard("Клирик", Person.Class.cleric));
        cards.add(new ClassCard("Вор", Person.Class.thief));
        cards.add(new ClassCard("Вор", Person.Class.thief));
        cards.add(new ClassCard("Воин", Person.Class.warrior));
        cards.add(new ClassCard("Воин", Person.Class.warrior));
        cards.add(new ClassCard("Маг", Person.Class.wizard));
        cards.add(new ClassCard("Маг", Person.Class.wizard));

        return cards;
    }
}
