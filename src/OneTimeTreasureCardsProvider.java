import java.util.ArrayList;
import java.util.List;

public class OneTimeTreasureCardsProvider {
    public List<OneTimeTreasureCard> getAllOneTimeCards() {

        List<OneTimeTreasureCard> cards = new ArrayList<>();

        OneTimeTreasureCard magic_rocket = new OneTimeTreasureCard("Ракета магического назначения", 300);
        magic_rocket.setPlay(new OneTimePlay() {
            @Override
            public void Play(OneTimeTreasureCard card, Selectable target) {
                Person2 person2 = (Person2) target;
                person2.power += 5;
            }

            @Override
            public void Leave(OneTimeTreasureCard card, Selectable target) {
                Person2 person2 = (Person2) target;
                person2.power -= 5;
            }
        });
        cards.add(magic_rocket);

        OneTimeTreasureCard enlightenment = new OneTimeTreasureCard("Достигни просветления", 0);
        magic_rocket.setPlay(new OneTimePlay() {
            @Override
            public void Play(OneTimeTreasureCard card, Selectable target) {
                Person2 person2 = (Person2) target;
                person2.level++;
            }

            @Override
            public void Leave(OneTimeTreasureCard card, Selectable target) {
            }
        });
        cards.add(enlightenment);

        return cards;
    }
}
