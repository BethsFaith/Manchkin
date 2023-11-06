package Cards.Treasures;

import Common.Selectable;

public interface OneTimePlay {
    void Play(OneTimeTreasureCard card, Selectable target);
    void Leave(OneTimeTreasureCard card, Selectable target);
}
