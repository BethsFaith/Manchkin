package Cards.Doors.Curses;

import Person.Person;

public interface CursePlay {
    boolean Play(CurseCard card, Person target);
    boolean Leave(CurseCard card, Person target);
}
