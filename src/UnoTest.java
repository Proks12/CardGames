import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {

    @org.junit.jupiter.api.Test
    void isAce() {
        Uno uno = new Uno();
        Card card = new Card(Colors.BLUE,Rank.ACE,null);
        assertEquals(true,uno.isAce(card));
    }



    @org.junit.jupiter.api.Test
    void drawCard() {
        Uno uno  = new Uno();
        Player player = new Player();
        Deck deck = new Deck();
        uno.drawCard(player);
        assertEquals(1,player.getCards().size());



    }

    @Test
    void playNormal() {
        Uno uno = new Uno();
        uno.playNormal(uno.gameFrame.hands.get(0).getItemAt(0));
        assertEquals(3,uno.gameFrame.hands.get(0).getItemCount());
    }






}