import BattleField.BattleField;
import Cards.Doors.Monster.Monster;
import Cards.Providers.*;
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
            System.out.printf("Суммарная сила %d\n", person.GetPower());
        }

        OneTimeTreasureCardsProvider oneTimeTreasureCardsProvider = new OneTimeTreasureCardsProvider();
        for (var obj : oneTimeTreasureCardsProvider.GetCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.GetPower());
            System.out.printf("Уровень %d\n", person.getLevel());
        }

        var cursesCardProvider = new CursesCardProvider();
        for (var obj : cursesCardProvider.GetCards()) {
            obj.Play(person);
            person.Calculate_Total_Damage();
            System.out.printf("Суммарная сила %d\n", person.GetPower());
            System.out.printf("Уровень %d\n", person.getLevel());
            System.out.printf("Расы %s\n", person.getRace());
        }


        var monsters = new MonsterProvider();

        var test_monster = (Monster) monsters.GetCards().get(0);

        var monsterBuffs = new MonsterBuffsProvider();

        System.out.printf("Монстр %s\n", test_monster.getName());
        System.out.printf("Суммарная сила монстра %d\n", test_monster.GetPower());
        System.out.printf("Сокровища за монстра %d\n", test_monster.getTreasuresCount());

        for (var obj : monsterBuffs.GetCards()) {
            obj.Play(test_monster);
            System.out.printf("Монстр %s\n", test_monster.getName());
            System.out.printf("Суммарная сила монстра %d\n", test_monster.GetPower());
            System.out.printf("Сокровища за монстра %d\n", test_monster.getTreasuresCount());
        }

        BattleField battleField = new BattleField();
        battleField.MonsterSide.Participants.add(test_monster);
        battleField.PlayerSide.Participants.add(person);

        System.out.print("Бой начался\n");
        StringBuilder names = new StringBuilder();
        for (var participant : battleField.MonsterSide.Participants) {
            var monster = (Monster)participant;
            names.append(monster.getName());
            names.append("(");
            names.append(monster.GetPower().toString());
            names.append(") ");
        }
        System.out.printf("Сторона монстров: %s\n", names.toString());

        names = new StringBuilder();
        for (Integer i = 1; i <= battleField.PlayerSide.Participants.size(); ++i) {
            names.append("Player");
            names.append(i.toString());
            names.append("(");
            names.append(person.GetPower().toString());
            names.append(") ");
        }
        System.out.printf("Сторона игроков: %s\n", names.toString());

        var playersWin = battleField.PlayerSide.GetPower() > battleField.MonsterSide.GetPower();
        System.out.printf("Победила сторона %s\n", playersWin ? "игроков" : "монстров");
    }
}