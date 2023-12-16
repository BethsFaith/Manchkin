package Cards.Doors.Classes;

import Loggers.Log;
import Cards.Doors.DoorCard;
import Common.Selectable;
import Person.Person;

import java.util.logging.Level;

public class ClassCard extends DoorCard {
    public ClassCard(String name, Person.Class type) {
        super(Type.CLASS);
        setName(name);
        this.type = type;
    }

    @Override
    public boolean Play(Selectable person) {
        Log.fmtGlobLog("Играем %s\n", this.getName());
        if(!(person instanceof Person)) {
            Log.fmtGlobLog(Level.SEVERE, "Попытка сыграть класс не на персонажа");
            return false;
        }
        ((Person)person).setClass(type);
        return true;
    }

    @Override
    public boolean Leave(Selectable person) {
        Log.fmtGlobLog("Уходит %s\n", this.getName());
        if(!(person instanceof Person cast)) {
            Log.fmtGlobLog(Level.SEVERE, "Попытка сыграть снять класс не с персонажа");
            return false;
        }
        if (cast.getCurClass() != type) {
            Log.fmtGlobLog(Level.SEVERE, "Класс изменен извне");
            return false;
        }
        cast.setClass(Person.Class.none);
        return true;


    }

    Person.Class type;
}
