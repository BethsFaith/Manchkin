package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Doors.Curses.*;
import Loggers.Log;

import Gear.WearableGear;
import Person.Person;

import java.util.ArrayList;

public class CursesCardProvider implements Deck.Provider {
    @Override
    public ArrayList<Card> GetCards() {
        var cards = new ArrayList<Card>();

        var gnusCurse = new CurseCard("Невыносимо гнусное проклятие", new CursePlay() {
            @Override
            public boolean Play(CurseCard card, Person target) {
                Log.fmtGlobLog("Играю %s\n", card.getName());
                int maxPower = -1;
                int maxPowerSlot = -1;
                if (target.helmet != null) {
                    if (target.helmet.getPower() > maxPower) {
                        maxPowerSlot = 0;
                        maxPower = target.helmet.getPower();
                    }
                }
                if (target.body != null) {
                    if (target.body.getPower() > maxPower) {
                        maxPowerSlot = 1;
                        maxPower = target.body.getPower();
                    }
                }
                if (target.legs != null) {
                    if (target.legs.getPower() > maxPower) {
                        maxPowerSlot = 2;
                        maxPower = target.legs.getPower();
                    }
                }
                WearableGear maxOther = null;
                for (var other : target.others) {
                    if (other.getPower() > maxPower) {
                        maxPower = other.getPower();
                        maxOther = other;
                        maxPowerSlot = 3;
                    }
                }
                switch (maxPowerSlot) {
                    case 0: {
                        target.helmet = null;
                         Log.fmtGlobLog("Lose helmet");
                        break;
                    }
                    case 1: {
                        target.body = null;
                         Log.fmtGlobLog("Lose body");
                        break;
                    }
                    case 2: {
                        target.legs = null;
                         Log.fmtGlobLog("Lose legs");
                        break;
                    }
                    case 3: {
                        target.others.remove(maxOther);
                         Log.fmtGlobLog("Lose other");
                        break;
                    }
                    default: {
                         Log.fmtGlobLog("Nothing to lose");
                    }
                }
                return false;
            }

            @Override
            public boolean Leave(CurseCard card, Person target) {
                return false;
            }
        });

        cards.add(gnusCurse);

        var loseHead = new CurseCard("Потеряй головняк", new CursePlay() {
            @Override
            public boolean Play(CurseCard card, Person target) {
                 Log.fmtGlobLog("Играю %s\n", card.getName());
                target.helmet = null;
                return false;
            }

            @Override
            public boolean Leave(CurseCard card, Person target) {
                return false;
            }
        });
        cards.add(loseHead);

        var loseLevel = new CurseCard("Потеряй уровень", new CursePlay() {
            @Override
            public boolean Play(CurseCard card, Person target) {
                 Log.fmtGlobLog("Играю %s\n", card.getName());
                target.decreaseLevel(1);
                return false;
            }

            @Override
            public boolean Leave(CurseCard card, Person target) {
                return false;
            }
        });
        cards.add(loseLevel);

        var loseRace = new CurseCard("Потеряй расу", new CursePlay() {
            @Override
            public boolean Play(CurseCard card, Person target) {
                 Log.fmtGlobLog("Играю %s\n", card.getName());
                target.setRace(Person.Race.human);
                return false;
            }

            @Override
            public boolean Leave(CurseCard card, Person target) {
                return false;
            }
        });

        cards.add(loseRace);

        var rock = new CurseCard("Роковой нырок", new CursePlay() {
            @Override
            public boolean Play(CurseCard card, Person target) {
                target.decreaseLevel(2);
                return true;
            }

            @Override
            public boolean Leave(CurseCard card, Person target) {
                target.increaseLevel(2);
                return true;
            }
        });

        cards.add(rock);

        return cards;
    }
}
