package Cards.Doors.MonsterBuffs;

import Cards.Doors.DoorCard;
import Cards.Doors.Monster.Monster;
import Common.Selectable;

public class MonsterBuff extends DoorCard {
    public MonsterBuff(String name) {
        super(Type.BATTLE);
        setName(name);
    }

    @Override
    public void Play(Selectable target) {
        System.out.printf("Play %s\n", this.getName());
        if (target instanceof Monster) {
            play.Play(this, (Monster) target);
        } else {
            System.out.println("Target not a monster");
        }
    }

    @Override
    public void Leave(Selectable target) {
        System.out.printf("Leave %s\n", this.getName());
        if (target instanceof Monster) {
            play.Leave(this, (Monster) target);
        } else {
            System.out.println("Target not a monster");
        }
    }

    public void setPlay(MonsterBuffPlay play) {
        this.play = play;
    }

    private MonsterBuffPlay play;
}
