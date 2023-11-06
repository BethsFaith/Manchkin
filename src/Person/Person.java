package Person;

import Gear.*;
import Common.Selectable;

import java.util.ArrayList;

public class Person extends Selectable {
    public enum Race{    //раса персонажа
        elf,            //эльф
        halfling,       //халфлинг
        dwarf,          //дварф
        half_breed,     //полукровка
        human           //человек
    }

    public enum Class{  //класс персонажа
        cleric,         //клирик
        wizard,         //волшебкик
        thief,          //вор
        warrior,        //воин
        none            //пусто
    }

    public static class ArmorHelmet {}

    @Override
    public void select() {

    }

    public Race getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Class getCur_class() {
        return cur_class;
    }

    public void setCur_class(Class cur_class) {
        this.cur_class = cur_class;
    }
    
    public void decreaseLevel(int points) {
        // понизить уровень на заданный points, проверить чтобы левел не был ниже начального(1)
    }

    public void increaseLevel(int points) {
        // повысить уровень на заданный points, проверить чтобы левел не был выше 10
    }

    public void resetLevel(){
        // сбросить уровень до начальноого
    }
    public ArrayList<WeaponGear> weapons; //оружие в руке
    public int hand_size = 0;
    public ArmorGear helmet;    //шлем
    public ArmorGear body;        //тело
    public ArmorGear legs;        //ноги
    public ArrayList<WearableGear> others; //оружие в руке
    Race race;          // текущая раса
    Class cur_class;    // текущий класс
    int level;          // текущий уровень
}
