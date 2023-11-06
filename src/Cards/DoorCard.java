package Cards;

public abstract class DoorCard extends Card {
    public enum Type {
        CURSE,
        MONSTER,
        RACE,
        SPECIALIZATION, // класс персонажа
        BATTLE
    }

    public DoorCard(Type type) {
        super(ShirtType.DOOR);

        this.type = type;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;
}
