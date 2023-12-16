package Cards.Treasures;

import Cards.Card;

public abstract class TreasureCard extends Card {
    public enum Type {
        ONE_TIME, // шмотка
        WEARABLE // шмотка
    }

    public TreasureCard(Type type) {
        super(ShirtType.TREASURE);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Type type;
    private int price;
}
