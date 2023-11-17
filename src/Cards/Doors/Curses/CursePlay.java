package Cards.Doors.Curses;

import Person.Person;

public interface CursePlay {
    void Play(CurseCard card, Person target);
    void Leave(CurseCard card, Person target);
}
