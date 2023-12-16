package Cards.Doors.Monster;

import BattleField.BattleField;
import Cards.Doors.DoorCard;
import Common.Selectable;
import Loggers.Log;
import Person.Person;

import java.util.logging.Level;

public class Monster extends DoorCard implements Selectable {
    public Monster(String name, Integer level, Integer treasures_count) {
        super(Type.MONSTER);
        setName(name);
        this.level = level;
        this.additional_power = 0;
        this.treasures_count = treasures_count;
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
        return play.Reverse(this, (Person) target);
    }

    public void Catch(Person target) {
        Log.fmtGlobLog("Непотребствует %s\n", this.getName());
        if (target == null) {
            Log.fmtGlobLog(Level.SEVERE, "Попытка передать null вместо Person");
            return;
        }
        if (catch_up != null) {
            catch_up.Catch(target);
        }
    }

    @Override
    public Integer GetPower() {
        return level + additional_power;
    }

    public Integer getTreasuresCount() {
        return treasures_count;
    }

    public void changeTreasureCount(int change) {
        treasures_count += change;
    }

    public void setPlay(MonsterPlay play) {
        if(play == null){
            Log.fmtGlobLog(Level.SEVERE, "Попытка присвоить null вместо MonsterPlay");
            return;
        }
        this.play = play;
    }

    public void setCatchUp(MonsterCatch catch_up) {
        this.catch_up = catch_up;
    }

    @Override
    public void ChangeAdditionalPower(int power_changes) {
        this.additional_power += power_changes;
    }

    public void ClearBonuses() {
        this.additional_power = 0;
    }

    private final Integer level;

    private Integer additional_power;
    private Integer treasures_count;

    private MonsterPlay play = new MonsterPlay() {
        @Override
        public boolean Condition(Person enemy) {
            return false;
        }
        @Override
        public boolean Play(Monster monster, Person enemy) {
            return true;
        }
        @Override
        public boolean Reverse(Monster monster, Person enemy) {
            return true;
        }
    };      // проверка условий (возможно что класс/раса персонажа дадут монстру бонус)

    private MonsterCatch catch_up = null; // непотребство
}

