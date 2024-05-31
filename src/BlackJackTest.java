import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {

    @Test
    void reducePlayerAce() {
        BlackJack blackJack = new BlackJack();
        blackJack.playerSum=22;
        blackJack.playerAceCount=1;
        blackJack.reducePlayerAce();
        assertEquals(12,blackJack.playerSum);
        assertEquals(0,blackJack.playerAceCount);




    }

    @Test
    void buildDeck() {
        BlackJack blackJack = new BlackJack();
        blackJack.buildDeck();
        assertEquals(52,blackJack.deck.size());


    }


}