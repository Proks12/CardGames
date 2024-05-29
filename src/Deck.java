import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    CardFaces cardFaces = new CardFaces();
    public List<Card> remainingDeck = new ArrayList<>();
    public List<Card> playedDeck= new ArrayList<>();
    private Card lastPlayedCard;
    private int i = 0;


    Deck(){

        for (Colors color : Colors.values()) {
            for (Rank rank : Rank.values()) {

                remainingDeck.add(new Card(color, rank,cardFaces.faces.get(i)));
                i++;
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(remainingDeck);
    }

    public Card getLastPlayedCard() {
        return lastPlayedCard;
    }

    public void setLastPlayedCard(Card lastPlayedCard) {
        this.lastPlayedCard = lastPlayedCard;
    }

}
