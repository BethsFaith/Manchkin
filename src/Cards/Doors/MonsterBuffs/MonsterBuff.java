package Cards.Doors.MonsterBuffs;

import Cards.Doors.DoorCard;
import Cards.Doors.Monster.Monster;
import Common.Selectable;
import Loggers.Log;

import java.util.logging.Level;

public class MonsterBuff extends DoorCard {
    public MonsterBuff(String name, MonsterBuffPlay play) {
        super(Type.BATTLE);
        setPlay(play);
        setName(name);
    }

    @Override
    public boolean Play(Selectable target) {
        Log.fmtGlobLog("Играем %s\n", this.getName());
        if (!(target instanceof Monster)) {
            Log.fmtGlobLog("Цель не монстр");
            return false;
        }
        return play.Play(this, (Monster) target);
    }

    @Override
    public boolean Leave(Selectable target) {
        Log.fmtGlobLog("Уходит %s\n", this.getName());
        if (!(target instanceof Monster)) {
            Log.fmtGlobLog("Цель не монстр");
            return false;
        }
        return play.Leave(this, (Monster) target);
    }

    public void setPlay(MonsterBuffPlay play) {
        if(play == null){
            throw new NullPointerException("Попытка присвоить null вместо MonsterBuffPlay");
        }
        this.play = play;
    }

    private MonsterBuffPlay play;
}
