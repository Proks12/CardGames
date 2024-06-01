import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    /**
     * Tests if the isAce method correctly identifies an Ace card.
     */

    @org.junit.jupiter.api.Test
    void isAce() {
        Uno uno = new Uno();
        Card card = new Card(Colors.BLUE,Rank.ACE,null);
        assertEquals(true,uno.isAce(card));
    }


    /**
     * Tests if the drawCard method correctly draws a card and adds it to the player's hand.
     */
    @org.junit.jupiter.api.Test
    void drawCard() {
        Uno uno  = new Uno();
        Player player = new Player();
        Deck deck = new Deck();
        uno.drawCard(player);
        assertEquals(1,player.getCards().size());



    }
    /**
     * Tests if the playNormal method correctly plays a card and removes it from the player's hand.
     */
    @Test
    void playNormal() {
        Uno uno = new Uno();
        uno.playNormal(uno.gameFrame.hands.get(0).getItemAt(0));
        assertEquals(3,uno.gameFrame.hands.get(0).getItemCount());
    }






}