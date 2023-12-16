package Cards.Doors.Monster;

import Person.Person;

public interface MonsterPlay {
    boolean Condition(Person enemy);
    boolean Play(Monster monster, Person enemy);
    boolean Reverse(Monster monster, Person enemy);
}