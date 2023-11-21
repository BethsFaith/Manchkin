package Cards.Doors.MonsterBuffs;

import Cards.Doors.Monster.Monster;

public interface MonsterBuffPlay {
    void Play(MonsterBuff card, Monster target);
    void Leave(MonsterBuff card, Monster target);
}

