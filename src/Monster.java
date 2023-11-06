public class Monster extends DoorCard {
    public Monster(Integer level, Integer treasuresCount) {
        this.level = level;
        this.bonus = 0;
        this.treasuresCount = treasuresCount;
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
        catchUp.Catch((Person)target);
    }

    public Integer GetStrength() {
        return level+bonus;
    }

    public Integer getTreasuresCount() {
        return treasuresCount;
    }

    public void AddBonus(Integer bonus) {
        this.bonus += bonus;
    }

    private final Integer level;
    private Integer bonus;
    private final Integer treasuresCount;

    private MonsterPlay play;     // проверка условий (возможно что класс/раса персонажа дадут монстру бонус)
    private MonsterCatch catchUp; // непотребство
}

