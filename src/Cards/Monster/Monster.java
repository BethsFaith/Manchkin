package Cards.Monster;

import Cards.DoorCard;
import Common.Selectable;
import Person.Person;

public class Monster extends DoorCard {
    public Monster(Integer level, Integer treasures_count) {
        this.level = level;
        this.bonus = 0;
        this.treasures_count = treasures_count;
    }

    @Override
    public void Play(Selectable target) {
        play.Play(this, (Person)target);
    }

    @Override
    public void Leave(Selectable target) {
        play.Reverse(this, (Person)target);
    }

    public void Catch(Selectable target) {
        catch_up.Catch((Person)target);
    }

    public Integer GetStrength() {
        return level+bonus;
    }

    public Integer getTreasuresCount() {
        return treasures_count;
    }

    public void setPlay(MonsterPlay play) {
        this.play = play;
    }

    public void setCatchUp(MonsterCatch catch_up) {
        this.catch_up = catch_up;
    }

    public void AddBonus(Integer bonus) {
        this.bonus += bonus;
    }

    public void ClearBonuses() {
        this.bonus = 0;
    }

    private final Integer level;
    private Integer bonus;
    private final Integer treasures_count;

    private MonsterPlay play;     // проверка условий (возможно что класс/раса персонажа дадут монстру бонус)
    private MonsterCatch catch_up; // непотребство
}

