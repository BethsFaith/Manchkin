package Cards.Treasures.OneTimePlayCards;

import Common.Selectable;

public interface OneTimePlay {
    boolean Play( OneTimeTreasureCard card,  Selectable target);
    boolean Leave( OneTimeTreasureCard card,  Selectable target);
}
