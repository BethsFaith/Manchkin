package Cards;

public abstract class TreasureCard extends Card {
    public enum Type {
        ONE_TIME, // шмотка
        WEARABLE // шмотка
    }

    public DoorCard.Type getType() {
        return type;
    }

    public void setType(DoorCard.Type type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private DoorCard.Type type;
    private Integer price;
}
