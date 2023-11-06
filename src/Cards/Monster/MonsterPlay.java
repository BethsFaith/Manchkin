package Cards.Monster;

import Person.Person;

public interface MonsterPlay {
    void Play(Monster monster, Person enemy);
    void Reverse(Monster monster, Person enemy);
}