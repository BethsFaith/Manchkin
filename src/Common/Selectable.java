package Common;

public abstract class Selectable {
    public abstract void select();
    public void changePower(int power_changes) {
        power += power_changes;
    }
    protected int power;
}
