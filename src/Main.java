import Cards.Providers.CursesCardProvider;
import Cards.Providers.WearableTreasureCardsProvider;
import Cards.Providers.OneTimeTreasureCardsProvider;
import Person.Person;
import Cards.*;

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
        WearableTreasureCardsProvider wearableTreasureCardsProvider = new WearableTreasureCardsProvider();

        for (var obj : wearableTreasureCardsProvider.GetCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.getTotal_damage());
        }

        OneTimeTreasureCardsProvider oneTimeTreasureCardsProvider = new OneTimeTreasureCardsProvider();
        for (var obj : oneTimeTreasureCardsProvider.GetCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.getTotal_damage());
            System.out.printf("Уровень %d\n", person.getLevel());
        }

        var cursesCardProvider = new CursesCardProvider();
        for (var obj : cursesCardProvider.GetCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.getTotal_damage());
            System.out.printf("Уровень %d\n", person.getLevel());
            System.out.printf("Расы %s\n", person.getRace());
        }
    }
}