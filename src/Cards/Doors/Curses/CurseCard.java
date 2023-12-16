package Cards.Doors.Curses;

import Cards.Doors.DoorCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class CurseCard extends DoorCard {
    public CurseCard(String name, CursePlay play) {
        super(Type.CURSE);
        setPlay(play);
        setName(name);
    }

    @Override

    public boolean Play(Selectable target) {
        Log.fmtGlobLog("Играем %s\n", this.getName());
        if (!(target instanceof Person)) {
            Log.fmtGlobLog(Level.SEVERE, "Цель не персонаж");
            return false;
        }
        return play.Play(this, (Person) target);
    }

    @Override
    public boolean Leave(Selectable target) {
        Log.fmtGlobLog("Уходит %s\n", this.getName());
        if (!(target instanceof Person)) {
            Log.fmtGlobLog(Level.SEVERE, "Цель не персонаж");
            return false;
        }
        return play.Leave(this, (Person) target);
    }

    public void setPlay(CursePlay play) {
        if(play == null){
            throw new NullPointerException("Попытка присвоить null вместо CursePlay");
        }
        this.play = play;
    }

    private CursePlay play;
}
