package BattleField;

import Common.Selectable;

import java.util.ArrayList;

public class BattleField {
    public static class Side implements Selectable {
        public enum Type {
            MONSTERS,
            PERSONS,
        }

        public Side(Type type) {
            this.Participants = new ArrayList<>();
            additional_power = 0;
        }
        @Override
        public void ChangeAdditionalPower(int power_points) {
            additional_power += power_points;
        }

        public Integer GetPower() {
            Integer power = 0;
            for (var participant : Participants) {
                power += participant.GetPower();
            }

            power += additional_power;

            return power;
        }

        public Type GetType() {
            return type;
        }

        public final ArrayList<Selectable> Participants;
        private int additional_power;
        private Type type;
    }

    public BattleField() {
        MonsterSide = new Side(Side.Type.MONSTERS);
        PlayerSide = new Side(Side.Type.PERSONS);
    }

    public Side MonsterSide;
    public Side PlayerSide;
}
