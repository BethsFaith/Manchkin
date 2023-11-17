package Cards.Doors.Monster;

import Person.Person;

public interface MonsterPlay {
    boolean Condition(Person enemy);
    void Play(Monster monster, Person enemy);
    void Reverse(Monster monster, Person enemy);
}