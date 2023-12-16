import BattleField.BattleField;
import Cards.DeckManager;
import Cards.Doors.Classes.ClassCard;
import Cards.Doors.Curses.CurseCard;
import Cards.Doors.DoorCard;
import Cards.Doors.Monster.Monster;
import Cards.Doors.MonsterBuffs.MonsterBuff;
import Cards.Doors.Races.RaceCard;
import Cards.Providers.*;
import Gear.WeaponGear;
import Loggers.Log;
import Person.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("/home/nyanbanan/IdeaProjects/Manchkin/logging.properties");
            Log.readProperty(fs);
        } catch (FileNotFoundException exc) {
            Log.fmtGlobLog(exc.toString());
        }
        Log.fmtGlobLog("\nНАБОР ТЕСТОВ ВСЕГО И СРАЗУ:\n");
        fullTests();
        Log.fmtGlobLog("\nНАБОР ПРОВАЛОВ:\n");
        allFailed();
        Log.fmtGlobLog("\nВЫВОД ВСЕХ КАРТ:\n");
        printDecks();
    }


    static void fullTests() {
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
            Log.fmtGlobLog("Суммарная сила %d\n", person.GetPower());
            Log.fmtGlobLog("\n");
        }

        OneTimeTreasureCardsProvider oneTimeTreasureCardsProvider = new OneTimeTreasureCardsProvider();
        for (var obj : oneTimeTreasureCardsProvider.GetCards()) {
            obj.Play(person);
            Log.fmtGlobLog("Суммарная сила %d\n", person.GetPower());
            Log.fmtGlobLog("Уровень %d\n", person.getLevel());
            Log.fmtGlobLog("\n");
        }

        var cursesCardProvider = new CursesCardProvider();
        for (var obj : cursesCardProvider.GetCards()) {
            obj.Play(person);
            Log.fmtGlobLog("Суммарная сила %d\n", person.GetPower());
            Log.fmtGlobLog("Уровень %d\n", person.getLevel());
            Log.fmtGlobLog("Расы %s\n", person.getRace());
            Log.fmtGlobLog("\n");
        }

        var monsters = new MonsterProvider();

        var test_monster = (Monster) monsters.GetCards().get(0);

        var monsterBuffs = new MonsterBuffsProvider();

        Log.fmtGlobLog("Монстр %s\n", test_monster.getName());
        Log.fmtGlobLog("Суммарная сила монстра %d\n", test_monster.GetPower());
        Log.fmtGlobLog("Сокровища за монстра %d\n", test_monster.getTreasuresCount());
        Log.fmtGlobLog("\n");


        for (var obj : monsterBuffs.GetCards()) {
            obj.Play(test_monster);
            Log.fmtGlobLog("Монстр %s\n", test_monster.getName());
            Log.fmtGlobLog("Суммарная сила монстра %d\n", test_monster.GetPower());
            Log.fmtGlobLog("Сокровища за монстра %d\n", test_monster.getTreasuresCount());
            Log.fmtGlobLog("\n");

        }

        RaceCard raceCard = new RaceCard("Эльф", Person.Race.elf);
        Log.fmtGlobLog("Раса игрока %s\n", person.getRace());
        Log.fmtGlobLog("Карта %s play на игрока\n", raceCard.getName());
        raceCard.Play(person);
        Log.fmtGlobLog("Раса игрока %s\n", person.getRace());
        Log.fmtGlobLog("\n");
        Log.fmtGlobLog("Карта %s leave\n", raceCard.getName());
        raceCard.Leave(person);
        Log.fmtGlobLog("Раса игрока %s\n", person.getRace());

        person.setClass(Person.Class.none);
        ClassCard classCard = new ClassCard("Клирик", Person.Class.cleric);
        Log.fmtGlobLog("\n");
        Log.fmtGlobLog("Класс игрока %s\n", person.getCurClass());
        Log.fmtGlobLog("Карта %s play на игрока\n", classCard.getName());
        classCard.Play(person);
        Log.fmtGlobLog("Класс игрока %s\n", person.getCurClass());
        Log.fmtGlobLog("Карта %s leave\n", classCard.getName());
        classCard.Leave(person);
        Log.fmtGlobLog("Класс игрока %s\n", person.getCurClass());

        BattleField battleField = new BattleField();
        battleField.MonsterSide.Participants.add(test_monster);
        battleField.PlayerSide.Participants.add(person);

        Log.fmtGlobLog("Бой начался\n");
        StringBuilder names = new StringBuilder();
        for (var participant : battleField.MonsterSide.Participants) {
            var monster = (Monster) participant;
            names.append(monster.getName());
            names.append("(");
            names.append(monster.GetPower().toString());
            names.append(") ");
        }
        Log.fmtGlobLog("Сторона монстров: %s\n", names.toString());

        names = new StringBuilder();
        for (Integer i = 1; i <= battleField.PlayerSide.Participants.size(); ++i) {
            names.append("Player");
            names.append(i.toString());
            names.append("(");
            names.append(person.GetPower().toString());
            names.append(") ");
        }
        Log.fmtGlobLog("Сторона игроков: %s\n", names.toString());

        var playersWin = battleField.PlayerSide.GetPower() > battleField.MonsterSide.GetPower();
        Log.fmtGlobLog("Победила сторона %s\n", playersWin ? "игроков" : "монстров");
    }

    static void allFailed() {
        var monsters = new MonsterProvider().GetCards();
        var test_monster = (Monster) monsters.get(0);
        test_monster.Play(null);
        test_monster.Leave(null);

        test_monster = new Monster("Тестовый монстр", 1, 1);
        test_monster.setPlay(null);

        try {
            var test_curse = new CurseCard("Тестовое проклятие", null);
        } catch (NullPointerException exc) {
            Log.fmtGlobLog(exc.toString());
        }

        try {
            var test_monster_buff = new MonsterBuff("Тестовый бафф", null);
        } catch (NullPointerException exc) {
            Log.fmtGlobLog(exc.toString());
        }

        var treasures = new WearableTreasureCardsProvider();
        var test_wearable = treasures.GetCards().get(0);
        test_wearable.Play(null);
        test_wearable.Leave(null);

        var test_person = new Person();
        var races = new RacesCardProvider();
        var test_race = races.GetCards().get(0);

        test_race.Play(null);
        test_race.Leave(null);

        test_race.Play(test_person);
        test_person.setRace(Person.Race.human);
        test_race.Leave(test_person);
    }

    static void printDecks() {
        var manager = new DeckManager();
        var door_deck = manager.getDoorDeck().getCards();
        for (Cards.Card card : door_deck) {
            Log.fmtGlobLog(card.getName() + " " + card.getShirtType());
        }
        var treasure_deck = manager.getTreasureDeck().getCards();
        for (Cards.Card card : treasure_deck) {
            Log.fmtGlobLog(card.getName() + " " + card.getShirtType());
        }
    }
}