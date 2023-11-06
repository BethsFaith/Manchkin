public class Person implements Selectable {
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
    @Override
    public void select() {

    }

    public Race getRace() {
        return race;
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

    Race race;          //текущая раса
    Class cur_class;    //текущий класс
}
