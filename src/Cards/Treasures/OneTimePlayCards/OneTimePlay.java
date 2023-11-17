package Cards.Treasures.OneTimePlayCards;

import Common.Selectable;

public interface OneTimePlay {
    void Play(OneTimeTreasureCard card, Selectable target);
    void Leave(OneTimeTreasureCard card, Selectable target);
}
