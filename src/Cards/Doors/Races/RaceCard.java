package Cards.Doors.Races;

import Cards.Doors.DoorCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class RaceCard extends DoorCard {
    public RaceCard(String name, Person.Race race) {
        super(Type.RACE);
        setName(name);
        this.race = race;
    }

    @Override
    public boolean Play(Selectable person) {
        if (!(person instanceof Person)) {
            Log.fmtGlobLog(Level.SEVERE, "Цель не персонаж");
            return false;
        }
        ((Person)person).setRace(race);
        return true;
    }

    @Override
    public boolean Leave(Selectable person) {
        if (!(person instanceof Person cast)) {
            Log.fmtGlobLog(Level.SEVERE, "Цель не персонаж");
            return false;
        }
        if (cast.getRace() != race) {
            Log.fmtGlobLog(Level.SEVERE, "Раса изменена извне");
            return false;
        }
        cast.setRace(Person.Race.human);
        return true;
    }

    private final Person.Race race;
}