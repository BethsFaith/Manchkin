public class WearableTreasureCard extends TreasureCard {
    public WearableTreasureCard(String name, int price, boolean is_big, int power) {
        setName(name);
        setPrice(price);
        this.is_big = is_big;
        this.power = power;
    }

    @Override
    public void Play(Selectable target) {
        play.Wear(this, (Person2) target);
    }

    @Override
    public void Leave(Selectable target) {
        play.UnWear(this, (Person2) target);
    }

    public void setPlay(WearablePlay play) {
        this.play = play;
    }

    WearablePlay play = null;
    boolean is_big = false;
    protected int power;
}
