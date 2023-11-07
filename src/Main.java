import Person.Person;
import Cards.*;
import Cards.Treasures.*;

public class Main {
    public static void main(String[] args) {
        DeckManager deckManager = new DeckManager();
        var doorDeck = deckManager.getDoorDeck();
        var cards = doorDeck.getCards();

        Person person = new Person();
        person.setRace(Person.Race.dwarf);
        for (var card : cards) {
            card.Play(person);
            card.Leave(person);
        }
        System.out.println(WearableTreasureCardsProvider.getAllWearableCards());

        for (var obj: WearableTreasureCardsProvider.getAllWearableCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.getTotal_damage());
        }

        for (var obj: OneTimeTreasureCardsProvider.getAllOneTimeCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.getTotal_damage());
            System.out.printf("Уровень %d\n", person.getLevel());
        }
    }
}