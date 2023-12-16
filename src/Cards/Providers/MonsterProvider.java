package Cards.Providers;

import Cards.Card;
import Cards.Deck;
import Cards.Doors.DoorCard;
import Cards.Doors.Monster.Monster;
import Cards.Doors.Monster.MonsterCatch;
import Cards.Doors.Monster.MonsterPlay;
import Cards.Doors.Races.RaceCard;
import Person.Person;

import java.util.ArrayList;

public class MonsterProvider implements Deck.Provider {
    @Override
    public ArrayList<Card> GetCards() {
        ArrayList<Card> cards = new ArrayList<>();

        // Бигфут
        ArrayList<Person.Race> races = new ArrayList<>();
        races.add(Person.Race.dwarf);
        races.add(Person.Race.halfling);
        MonsterPlay bigFootPlay = RaceBonusPlay(races, 3);
        MonsterCatch bigFootCatch = enemy -> {
            enemy.helmet = null;
        };

        Monster bigFoot = new Monster("Бигфут", 12, 3);
        bigFoot.setPlay(bigFootPlay);
        bigFoot.setCatchUp(bigFootCatch);
        cards.add(bigFoot);

        // Гик
        ArrayList<Person.Class> classes = new ArrayList<>();
        classes.add(Person.Class.warrior);
        MonsterPlay gicPlay = ClassBonusPlay(classes, 6);

        MonsterCatch gicCatch = enemy -> {
            enemy.setClass(null);
            enemy.setRace(null);
        };
        Monster gic = new Monster("Гикающий гик", 6, 2);
        gic.setPlay(gicPlay);
        gic.setCatchUp(gicCatch);
        cards.add(gic);

        // Бледные братья
        MonsterCatch brothersCatch = enemy -> {
            if (enemy.getLevel() <= 3) {
                enemy.resetLevel(); // сброс уровня на первый
            }
        };
        Monster brothers = new Monster("Братья", 16, 4);
        brothers.setCatchUp(brothersCatch);

        cards.add(brothers);

        // Молотая красотка
        ArrayList<Person.Class> classes2 = new ArrayList<>();
        classes2.add(Person.Class.cleric);
        MonsterPlay beautyPlay = ClassBonusPlay(classes2, 3);
        MonsterCatch beautyCatch = enemy -> {
            enemy.decreaseLevel(-1);
        };
        Monster beauty = new Monster("Крысавица", 1, 1);
        beauty.setPlay(beautyPlay);
        beauty.setCatchUp(beautyCatch);

        cards.add(beauty);

        Monster goblin = new Monster("Уверенный гоблин", 1, 1);
        goblin.setPlay(new MonsterPlay() {
            @Override
            public boolean Condition(Person enemy) {
                return true;
            }

            @Override
            public boolean Play(Monster monster, Person enemy) {
                enemy.changeRunAwayBonus(1);
                return true;
            }

            @Override
            public boolean Reverse(Monster monster, Person enemy) {
                enemy.changeRunAwayBonus(-1);
                return true;
            }
        });
        goblin.setCatchUp(new MonsterCatch() {
            @Override
            public void Catch(Person enemy) {
                enemy.decreaseLevel(1);
            }
        });
        cards.add(goblin);

        var vosh = new Monster("Вошки", 1, 1);
        vosh.setPlay(new MonsterPlay() {
            @Override
            public boolean Condition(Person enemy) {
                return true;
            }

            @Override
            public boolean Play(Monster monster, Person enemy) {
                enemy.changeRunAwayBonus(-999);
                return true;
            }

            @Override
            public boolean Reverse(Monster monster, Person enemy) {
                enemy.changeRunAwayBonus(999);
                return true;
            }
        });
        vosh.setCatchUp(new MonsterCatch() {
            @Override
            public void Catch(Person enemy) {
                enemy.legs = null;
            }
        });
        cards.add(vosh);

        var kitty = new Monster("Служитель мимиды", 14, 4);
        var kitty_classes = new ArrayList<Person.Class>();
        kitty_classes.add(Person.Class.thief);
        kitty.setPlay(ClassBonusPlay(kitty_classes, 4));
        kitty.setCatchUp(new MonsterCatch() {
            @Override
            public void Catch(Person enemy) {
                enemy.weapons.get(0).unwear(enemy);
            }
        });
        cards.add(kitty);
        return cards;
    }

    static private MonsterPlay ClassBonusPlay(ArrayList<Person.Class> personClasses, Integer bonus) {
        return new MonsterPlay() {
            @Override
            public boolean Condition(Person enemy) {
                boolean predicate = false;
                Person.Class cur_class = enemy.getCurClass();
                for (Person.Class personClass : personClasses) {
                    predicate |= (cur_class == personClass);
                }
                return predicate;
            }

            @Override
            public boolean Play(Monster monster, Person enemy) {
                if (Condition(enemy)) {
                    monster.ChangeAdditionalPower(bonus);
                }
                return true;
            }

            @Override
            public boolean Reverse(Monster monster, Person enemy) {
                if (Condition(enemy)) {
                    monster.ChangeAdditionalPower(-bonus);
                }
                return true;
            }
        };
    }

    static private MonsterPlay RaceBonusPlay(ArrayList<Person.Race> personRaces, Integer bonus) {
        return new MonsterPlay() {
            @Override
            public boolean Condition(Person enemy) {
                boolean predicate = false;
                Person.Race cur_race = enemy.getRace();
                for (Person.Race race : personRaces) {
                    predicate |= (cur_race == race);
                }
                return predicate;
            }

            @Override
            public boolean Play(Monster monster, Person enemy) {
                if (Condition(enemy)) {
                    monster.ChangeAdditionalPower(bonus);
                }
                return true;
            }

            @Override
            public boolean Reverse(Monster monster, Person enemy) {
                if (Condition(enemy)) {
                    monster.ChangeAdditionalPower(-bonus);
                }
                return true;
            }
        };
    }
}
