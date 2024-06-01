import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    CardFaces cardFaces = new CardFaces();
    public List<Card> remainingDeck = new ArrayList<>();
    public List<Card> playedDeck= new ArrayList<>();
    private Card lastPlayedCard;
    private int i = 0;

    /**
     * Constructs a Deck object, initializes the deck with cards, and shuffles the deck.
     */
    Deck(){

        for (Colors color : Colors.values()) {
            for (Rank rank : Rank.values()) {

                remainingDeck.add(new Card(color, rank,cardFaces.faces.get(i)));
                i++;
            }
        }
        shuffleDeck();
    }
    /**
     * Shuffles the remaining deck of cards.
     */
    public void shuffleDeck() {
        Collections.shuffle(remainingDeck);
    }
    /**
     * Returns the last played card.
     *
     * @return The last played card.
     */
    public Card getLastPlayedCard() {
        return lastPlayedCard;
    }
    /**
     * Sets the last played card.
     *
     * @param lastPlayedCard The card to be set as the last played card.
     */
    public void setLastPlayedCard(Card lastPlayedCard) {
        this.lastPlayedCard = lastPlayedCard;
    }

}
