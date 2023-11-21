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
            this.participants = new ArrayList<>();
            additional_power = 0;
        }

        @Override
        public void Select() {}

        @Override
        public void ChangePower(int power_points) {
            additional_power += power_points;
        }

        public void AddParticipant(Selectable participant) {
            participants.add(participant);
        }

        public void RemoveParticipant(Selectable participant) {
            participants.remove(participant);
        }

        public Integer GetPower() {
            Integer power = 0;
            for (var participant : participants) {
                power += participant.GetPower();
            }

            power += additional_power;

            return power;
        }

        public Type GetType() {
            return type;
        }

        private final ArrayList<Selectable> participants;
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
