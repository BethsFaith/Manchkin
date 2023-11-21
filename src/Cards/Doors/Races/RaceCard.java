package Cards.Doors.Races;

import Cards.Doors.DoorCard;
import Common.Selectable;
import Person.Person;

public class RaceCard extends DoorCard {
    public RaceCard(Person.Race race) {
        super(Type.RACE);

        this.race = race;
    }

    @Override
    public void Play(Selectable target) {
        var person = (Person)target;
        if (person == null) {
            return; // TODO: обсудить возврат ошибок
        }

        person.setRace(race);
    }

    @Override
    public void Leave(Selectable target) {
        var person = (Person)target;
        if (person == null) {
            return; // TODO: обсудить возврат ошибок
        }

        if (person.getRace() != race) {
            return; // TODO: обсудить возврат ошибок
        }
        person.setRace(Person.Race.human);
    }

    private final Person.Race race;
}