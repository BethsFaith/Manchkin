package Cards.Treasures.OneTimePlayCards;
import Cards.Treasures.TreasureCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class OneTimeTreasureCard extends TreasureCard {
    public OneTimeTreasureCard(String name, int price, OneTimePlay play) {
        super(Type.ONE_TIME);
        setName(name);
        setPrice(price);
        setPlay(play);
    }
    public void setPlay( OneTimePlay play) {
        if(play == null){
            throw new NullPointerException("Попытка присвоить null вместо OneTimeTreasurePlay");
        }
        this.play = play;
    }
    @Override
    public boolean Play(Selectable target) {
        Log.fmtGlobLog("Играем %s\n", this.getName());
        if(!(target instanceof Person)){
            Log.fmtGlobLog("Цель не персонаж");
            return false;
        }
        return play.Play(this, target);
    }
    @Override
    public boolean Leave(Selectable target) {
        Log.fmtGlobLog("Уходит %s\n", this.getName());
        if(!(target instanceof Person)){
            Log.fmtGlobLog("Цель не персонаж");
            return false;
        }
        return play.Leave(this, target);
    }
    OneTimePlay play;
}
