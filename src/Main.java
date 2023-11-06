public class Main {
    public static void main(String[] args) {
        // пример карты Бигфута
        MonsterPlay monsterPlay = new MonsterPlay() {
            @Override
            public void Play(Monster monster, Person enemy) {
                if (enemy.getRace() == Person.Race.dwarf || enemy.getRace() == Person.Race.halfling) {
                    monster.AddBonus(3);
                }
            }
            @Override
            public void Reverse(Monster monster, Person enemy) {
                if (enemy.getRace() == Person.Race.dwarf || enemy.getRace() == Person.Race.halfling) {
                    monster.AddBonus(-3);
                }
            }
        };
        MonsterCatch catchUp = enemy -> {
            enemy.setHelmet(null);
        };

        Monster bigFoot = new Monster(12, 3);
        bigFoot.setPlay(monsterPlay);
        bigFoot.setCatchUp(catchUp);
    }
}