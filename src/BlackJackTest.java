import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {
    /**
     * Tests if the reducePlayerAce method correctly reduces the player's sum
     * when they have an Ace and their sum exceeds 21.
     */
    @Test
    void reducePlayerAce() {
        BlackJack blackJack = new BlackJack();
        blackJack.playerSum=22;
        blackJack.playerAceCount=1;
        blackJack.reducePlayerAce();
        assertEquals(12,blackJack.playerSum);
        assertEquals(0,blackJack.playerAceCount);




    }
    /**
     * Tests if the buildDeck method correctly builds a full deck of 52 cards.
     */
    @Test
    void buildDeck() {
        BlackJack blackJack = new BlackJack();
        blackJack.buildDeck();
        assertEquals(52,blackJack.deck.size());


    }


}