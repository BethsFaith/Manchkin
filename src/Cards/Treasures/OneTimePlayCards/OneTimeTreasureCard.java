package Cards.Treasures.OneTimePlayCards;
import Cards.Treasures.TreasureCard;
import Common.Selectable;

public class OneTimeTreasureCard extends TreasureCard {
    public OneTimeTreasureCard(String name, int price) {
        super(Type.ONE_TIME);
        setName(name);
        setPrice(price);
    }

    @Override
    public void Play(Selectable target) {
        play.Play(this, target);
    }

    @Override
    public void Leave(Selectable target) {
        play.Leave(this, target);
    }

    public void setPlay(OneTimePlay play) {
        this.play = play;
    }

    OneTimePlay play;
}
