package Cards.Treasures.WearableCards;
import Cards.Treasures.TreasureCard;
import Common.Selectable;
import Gear.WearableGear;
import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class WearableTreasureCard extends TreasureCard {
    public WearableTreasureCard(String name, int price, WearableGear gear) {
        super(Type.WEARABLE);
        if(gear == null){
            throw new NullPointerException("Попытка присвоить null вместо WearableGear");
        }
        this.gear = gear;
        setName(name);
        setPrice(price);
    }

    @Override
    public boolean Play(Selectable target) {
        Log.fmtGlobLog("Играем %s\n", this.getName());
        if (!(target instanceof Person)){
            Log.fmtGlobLog("Цель не персонаж");
            return false;
        }
        return play.WearWithCheck(gear, (Person) target);
    }

    @Override
    public boolean Leave(Selectable target) {
        Log.fmtGlobLog("Уходит %s\n", this.getName());
        if (!(target instanceof Person)){
            Log.fmtGlobLog("Цель не персонаж");
            return false;
        }
        return play.UnWearWithCheck(gear, (Person) target);
    }

    public void setPlay( WearablePlay play) {
        if(play == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка присвоить null вместо WearablePlay");
            return;
        }
        this.play = play;
    }

    WearablePlay play = new WearablePlay() {
        @Override
        public boolean WearWithCheck( WearableGear wearable,  Person target) {
            return gear.wear(target);
        }

        @Override
        public boolean UnWearWithCheck( WearableGear wearable,  Person target) {
            return gear.unwear(target);
        }
    };
    WearableGear gear;
}
