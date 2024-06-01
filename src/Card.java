import javax.swing.*;

public class Card {
    private Colors colors;
    private Rank rank;
    private ImageIcon face;
    /**
     * Constructs a card with the specified color, rank, and face image.
     *
     * @param colors The color of the card (e.g., BLUE, RED, YELLOW, GREEN).
     * @param rank   The rank of the card (e.g., ZERO, ONE, TWO, ..., JACK, ACE, PLUSTWO).
     * @param face   The face image of the card.
     */
    public Card(Colors colors, Rank rank, ImageIcon face) {
        this.colors = colors;
        this.rank = rank;
        this.face = face;
    }


    /**
     * Returns the rank of the card.
     *
     * @return The rank of the card.
     */
    public Rank getRank() {
        return rank;
    }
    /**
     * Returns the face image of the card.
     *
     * @return The face image of the card.
     */
    public ImageIcon getFace() {
        return face;
    }
    /**
     * Returns the color of the card.
     *
     * @return The color of the card.
     */
    public Colors getColor() {
        return colors;
    }
    /**
     * Sets the color of the card.
     *
     * @param color The color to set for the card.
     */
    public void setColor(Colors color) {
        this.colors = colors;
    }

    public Character suitString(){

/**
 * Returns a character representing the color of the card.
 *
 * @return A character representing the color of the card (B, R, Y, G).
 */
        switch (colors){
            case BLUE -> {
                return 'B';
            }
            case RED -> {
                return 'R';
            }
            case YELLOW -> {
                return 'Y';
            }
            case GREEN -> {
                return 'G';
            }
        }
        return null;
    }
    /**
     * Returns a string representing the rank of the card.
     *
     * @return A string representing the rank of the card.
     */
    public String rankString(){
        switch (rank){
            case ZERO ->{
                return "0";
            }
            case ONE ->{
                return "1";
            }
            case TWO ->{
                return "2";
            }
            case THREE ->{
                return "3";
            }
            case FOUR ->{
                return "4";
            }
            case FIVE ->{
                return "5";
            }
            case SIX ->{
                return "6";
            }
            case SEVEN ->{
                return "7";
            }
            case EIGHT ->{
                return "8";
            }
            case NINE ->{
                return "9";
            }
            case JACK ->{
                return "J";
            }
            case ACE ->{
                return "A";
            }
            case PLUSTWO ->{
                return "+2";
            }

        }
        return null;
    }
    /**
     * Returns the string representation of the card.
     *
     * @return A string representing the card in the format "rankColor".
     */
    @Override
    public String toString() {
        return rankString() + suitString();
    }


}

