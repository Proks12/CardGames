import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uno implements ActionListener {

    GameFrame gameFrame = new GameFrame();
    Deck deck = new Deck();
    Player[] players = new Player[3];
    int playerPlays = 0;

    public Uno() {

        deck.setLastPlayedCard(deck.remainingDeck.get(12));
        deck.remainingDeck.remove(12);
        for (int i = 0; i < 3; i++) {

            Player player = new Player();
            players[i] = player;

            for (int j = 0; j < 4; j++) {

                drawCard(players[i]);
            }
        }

        gameFrame.playButton.addActionListener(this);
        gameFrame.deck.addActionListener(this);

        for (int i = 0; i < 3; i++) {

            gameFrame.hands.get(i).addActionListener(this);
        }

        gameFrame.lastCardLabel.setIcon(deck.getLastPlayedCard().getFace());
        gameFrame.repaint();

        for (int i = 0; i < 4; i++) {

            gameFrame.hands.get(0).addItem(players[0].getCards().get(i));
            gameFrame.hands.get(1).addItem(players[1].getCards().get(i));
            gameFrame.hands.get(2).addItem(players[2].getCards().get(i));
            gameFrame.changeButtons[i].addActionListener(this);
        }
    }

    /**
     * This method sets the player to the next one and changes the colors of the player's labels.
     */
    public void nextPlayer(){

        playerPlays++;
        playerPlays %= 3;

        for (int i = 0; i < 3; i++){

            gameFrame.playerPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            gameFrame.playerLabels.get(i).setForeground(Color.gray);
        }

        switch (playerPlays){

            case 0 :
                gameFrame.playerPanels.get(0).setBorder(BorderFactory.createLineBorder(Color.white, 3));
                gameFrame.playerLabels.get(0).setForeground(Color.white);
                break;
            case 1 :
                gameFrame.playerPanels.get(1).setBorder(BorderFactory.createLineBorder(Color.white, 3));
                gameFrame.playerLabels.get(1).setForeground(Color.white);
                break;
            case 2 :
                gameFrame.playerPanels.get(2).setBorder(BorderFactory.createLineBorder(Color.white, 3));
                gameFrame.playerLabels.get(2).setForeground(Color.white);
                break;
        }
    }

    /**
     *This method finds out if the played card is a seven, ace, jack or other card and calls next method for that card.
     * @param card
     */
    public void playCard(Card card){

        if (isPlusTwo(card)){
            playNormal(card);
            playPlusTwo();
        }
        if (isAce(card)){
            playAce(card);
        }
        if (isJack(card)){
            playJack(card);
        }
        else if (IsNormalCard(card)){

            playNormal(card);

        }

    }

    /**
     * This boolean finds out if the played card can be played.
     * @param card
     * @return
     */
    public boolean IsNormalCard(Card card) {

        return card.getColor().equals(deck.getLastPlayedCard().getColor()) ||
                card.getRank().equals(deck.getLastPlayedCard().getRank()) &&
                        !isJack(card) && !isPlusTwo(card) && !isAce(card);
    }

    /**
     * This boolean finds out if the played card is a seven.
     * @param card
     * @return
     */
    public boolean isPlusTwo(Card card){

        return card.getRank().equals(Rank.PLUSTWO);
    }

    /**
     * This boolean finds out if the played card is an ace.
     * @param card
     * @return
     */
    public boolean isAce(Card card){

        return card.getRank().equals(Rank.ACE);
    }

    /**
     * This boolean finds out if the played card is a jack.
     * @param card
     * @return
     */
    public boolean isJack(Card card){

        return card.getRank().equals(Rank.JACK);
    }

    /**
     * This method plays the card the player wants to play.
     * @param card
     */
    public void playNormal(Card card) {
        deck.setLastPlayedCard(card);
        deck.playedDeck.add(card);
        players[playerPlays].getCards().remove(card);

        gameFrame.lastCardLabel.setIcon(deck.getLastPlayedCard().getFace());
        gameFrame.hands.get(playerPlays).removeItem(card);
        checkWin();
    }

    /**
     * This method is called when the card played is a seven and plays its special properties.
     */
    public void playPlusTwo() {

        for (int i = 0; i < 2; i++) {

            drawCard(players[playerPlays]);

            switch(playerPlays) {

                case 0:
                    gameFrame.hands.get(0).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size() - 1));
                    break;
                case 1:
                    gameFrame.hands.get(1).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size() - 1));
                    break;
                case 2:
                    gameFrame.hands.get(2).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size() - 1));
                    break;
            }
        }
    }

    /**
     * This method is called when the card played is an ace and plays its special properties.
     * @param card
     */
    public void playAce(Card card) {
        deck.setLastPlayedCard(card);
        deck.playedDeck.add(card);
        players[playerPlays].getCards().remove(card);
        gameFrame.lastCardLabel.setIcon(deck.getLastPlayedCard().getFace());
        gameFrame.hands.get(playerPlays).removeItem(card);
        checkWin();
    }

    /**
     * This method is called when the card played is a jack and plays its special properties.
     * @param card
     */
    public void playJack(Card card) {

        deck.setLastPlayedCard(card);
        deck.playedDeck.add(card);
        players[playerPlays].getCards().remove(card);

        gameFrame.lastCardLabel.setIcon(deck.getLastPlayedCard().getFace());
        gameFrame.hands.get(playerPlays).removeItem(card);
        checkWin();
        gameFrame.changePanel.setVisible(true);
        gameFrame.playButton.setEnabled(false);
    }

    /**
     * This method draws the playing card.
     * @param player
     */
    public void drawCard(Player player){

        player.getCards().add(deck.remainingDeck.get(0));
        deck.remainingDeck.remove(0);
        resetDeck();
    }

    /**
     * This method checks if the player has an empty hand. If so, end the game and determines the winner.
     */
    public void checkWin(){

        if (players[playerPlays].getCards().isEmpty()){

            for (int i = 0; i < 3; i++) {


                gameFrame.hands.get(i).setEnabled(false);
                gameFrame.playerPanels.get(i).setBorder(BorderFactory.createLineBorder(Color.gray, 3));
                gameFrame.playerLabels.get(i).setForeground(Color.gray);
            }

            gameFrame.playButton.setEnabled(false);
            gameFrame.playButton.setForeground(Color.gray);
            gameFrame.playButton.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
            gameFrame.deck.setEnabled(false);
            gameFrame.winLabel.setText("Player " + (playerPlays+1) + " won");
            gameFrame.winPanel.setVisible(true);

        }else nextPlayer();
    }

    /**
     * This method finds out if the draw pack is empty and if it is, it takes cards from the discard pack, shuffles them and puts them in the draw pack.
     */
    public void resetDeck(){
        if (deck.remainingDeck.isEmpty()){
            for (int i = 0; i < deck.playedDeck.size();i++){

                deck.remainingDeck.add(deck.playedDeck.get(0));
                deck.playedDeck.remove(0);

            }
            deck.shuffleDeck();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(gameFrame.playButton)){

            playCard(players[playerPlays].getCards().get(gameFrame.hands.get(playerPlays).getSelectedIndex()));

        }

        if (e.getSource().equals(gameFrame.deck)){

            drawCard(players[playerPlays]);
            switch (playerPlays){

                case 0:
                    gameFrame.hands.get(0).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size()-1));
                    break;
                case 1:
                    gameFrame.hands.get(1).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size()-1));
                    break;
                case 2:
                    gameFrame.hands.get(2).addItem(players[playerPlays].getCards().get(players[playerPlays].getCards().size()-1));
                    break;
            }

            nextPlayer();
        }

        if (e.getSource().equals(gameFrame.changeButtons[0])){
            deck.getLastPlayedCard().setColor(Colors.BLUE);
            gameFrame.changePanel.setVisible(false);
            gameFrame.playButton.setEnabled(true);
        }

        if (e.getSource().equals(gameFrame.changeButtons[1])){
            deck.getLastPlayedCard().setColor(Colors.RED);
            gameFrame.changePanel.setVisible(false);
            gameFrame.playButton.setEnabled(true);
        }

        if (e.getSource().equals(gameFrame.changeButtons[2])){
            deck.getLastPlayedCard().setColor(Colors.YELLOW);
            gameFrame.changePanel.setVisible(false);
            gameFrame.playButton.setEnabled(true);
        }

        if (e.getSource().equals(gameFrame.changeButtons[3])){
            deck.getLastPlayedCard().setColor(Colors.GREEN);
            gameFrame.changePanel.setVisible(false);
            gameFrame.playButton.setEnabled(true);
        }
    }
}

