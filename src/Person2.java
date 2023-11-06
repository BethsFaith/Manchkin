import java.util.ArrayList;

public class Person2 extends Selectable {
    public enum Race {          //раса персонажа
        elf,            //эльф
        halfling,       //халфлинг
        dwarf,          //дварф
        half_breed,     //полукровка
        human;           //человек
    }

    public enum Class {         //класс персонажа
        cleric,         //клирик
        wizard,         //волшебкик
        thief,          //вор
        warrior,        //воин
        none            //пусто
    }

    @Override
    public void select() {

    }
    ArrayList<WearableTreasureCard> weapons; //оружие в руке
    int hand_size = 0;
    WearableTreasureCard helmet;    //шлем
    WearableTreasureCard body;        //тело
    WearableTreasureCard legs;        //ноги
    ArrayList<WearableTreasureCard> others; //оружие в руке
    Race my_race;
    Class my_class;
    public int power = 0;
    public int level = 1;
}
