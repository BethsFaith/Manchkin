package Cards.Doors.MonsterBuffs;

import Cards.Doors.Monster.Monster;

public interface MonsterBuffPlay {
    boolean Play(MonsterBuff card, Monster target);
    boolean Leave(MonsterBuff card, Monster target);
}

