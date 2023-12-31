package Person;

import Gear.*;
import Common.Selectable;

import java.util.ArrayList;

public class Person implements Selectable {
    public enum Race {    //раса персонажа
        elf,            //эльф
        halfling,       //халфлинг
        dwarf,          //дварф
        half_breed,     //полукровка
        human           //человек
        ;
    }

    public enum Class {  //класс персонажа
        cleric,         //клирик
        wizard,         //волшебкик
        thief,          //вор
        warrior,        //воин
        none            //пусто
        ;
    }
    @Override
    public void ChangeAdditionalPower(int power_changes) {
        additional_power += power_changes;
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

    public Class getCurClass() {
        return cur_class;
    }

    public void setClass(Class cur_class) {
        this.cur_class = cur_class;
    }

    private void calculateTotalDamage() { //высчитывает общую силу
        int temp = 0;
        temp += this.level;

        for (var w : this.weapons)
            temp += w.getPower();
        for (var o : this.others)
            temp += o.getPower();

        temp += helmet != null ? helmet.getPower() : 0;
        temp += body != null ? body.getPower() : 0;
        temp += legs != null ? legs.getPower() : 0;

        temp += this.additional_power;

        this.total_damage = temp;
    }

    public void decreaseLevel(int points) {
        // понизить уровень на заданный points, проверить чтобы левел не был ниже начального(1)
        while (points-- > 0 && level > 1) {
            --level;
        }
    }

    public void increaseLevel(int points) {
        // повысить уровень на заданный points, проверить чтобы левел не был выше 10
        while (points-- > 0 && level < 10) {
            level += 1;
        }
    }

    public void resetLevel() {
        // сбросить уровень до начальноого
        level = 1;
    }

    @Override
    public Integer GetPower() {
        calculateTotalDamage();
        return total_damage;
    }

    public boolean isHaveBig() {
        return have_big;
    }

    public void setHaveBig(boolean have_big) {
        this.have_big = have_big;
    }

    public int getRunawayBonus() {
        return runaway_bonus;
    }

    public void changeRunAwayBonus(int change_value) {
        this.runaway_bonus += change_value;
    }

    public ArrayList<WeaponGear> weapons = new ArrayList<>(); //оружие в руке
    public int hand_size = 0;
    public ArmorGear helmet;    //шлем
    public ArmorGear body;        //тело
    public ArmorGear legs;        //ноги
    public ArrayList<WearableGear> others = new ArrayList<>(); //другое снаряжение
    Race race = Race.human;          // текущая раса
    Class cur_class = Class.none;    // текущий класс
    int level = 1;          // текущий уровень

    private int total_damage; //суммарная сила
    private int additional_power; //сила из доп источников

    private int runaway_bonus = 0; //бонус смывки
    boolean have_big = false; //держит ли персонаж большую снарягу
}
