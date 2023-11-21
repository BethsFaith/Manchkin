package Cards.Doors.Classes;

import Cards.Doors.DoorCard;
import Common.Selectable;
import Person.Person;

public class ClassCard extends DoorCard {
    public ClassCard(Person.Class type) {
        super(Type.CLASS);
        this.type = type;
    }

    @Override
    public void Play(Selectable target) {
        var person = (Person)target;
        if (person == null) {
            return; // TODO: обсудить возврат ошибок
        }

        person.setCur_class(type);
    }

    @Override
    public void Leave(Selectable target) {
        var person = (Person)target;
        if (person == null) {
            return; // TODO: обсудить возврат ошибок
        }

        if (person.getCur_class() != type) {
            return; // TODO: обсудить возврат ошибок
        }
        person.setCur_class(Person.Class.none);
    }

    Person.Class type;
}
