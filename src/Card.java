import javax.swing.*;

public class Card {
    private Colors colors;
    private Rank rank;
    private ImageIcon face;

    public Card(Colors colors, Rank rank, ImageIcon face) {
        this.colors = colors;
        this.rank = rank;
        this.face = face;
    }



    public Rank getRank() {
        return rank;
    }

    public ImageIcon getFace() {
        return face;
    }

    public Colors getColor() {
        return colors;
    }

    public void setColor(Colors color) {
        this.colors = colors;
    }

    public Character suitString(){


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

    @Override
    public String toString() {
        return rankString() + suitString();
    }


}

