/**
 * Created by Jsin on 4/11/2016.
 */
public class Card {

    // Suit values

    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    public static final int SPADES =4;

    // Face values

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // Suit Names
    private final String[] suitNames = new String[]
            {"Clubs","Diamonds","Hearts","Spades"};

    // Face names
    private final String[] faceNames = new String[]
            {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace",};

    // Card Values
    private  int deckValue;
    private  int faceValue;
    private  int suitValue;

    public Card(int deckValue){
        if ((deckValue <1) || deckValue > 52){
            throw new IllegalArgumentException();
        }

        this.deckValue = deckValue;
        faceValue = toFaceValue(deckValue);
        suitValue = toSuitValue(deckValue);
    }

    public Card(int faceValue, int suitValue){
        if ((faceValue < 2) || (suitValue > 14)){
            throw new IllegalArgumentException();
        }
        if ((suitValue <1) || (suitValue > 4)){
            throw new IllegalArgumentException();
        }

        this.faceValue = faceValue;
        this.suitValue = suitValue;
        this.deckValue = toDeckValue(faceValue,suitValue);

    }

    public int getDeckValue() {
        return deckValue;
    }

    public String getFaceName(){
        return faceNames[faceValue - 2];
    }

    public int getFaceValue(){
        return faceValue;
    }

    public String getSuitName(){
        return suitNames[suitValue - 1];
    }

    public int getSuitValue(){
        return suitValue;
    }

    public static int toDeckValue(int faceValue, int suitValue) {
        if ((faceValue < 2) || (suitValue > 14)){
            throw new IllegalArgumentException();
        }
        if ((suitValue <1) || (suitValue > 4)){
            throw new IllegalArgumentException();
        }

        int convertedDeckValue = (13 * (suitValue - 1)) + faceValue - 1;
        return convertedDeckValue;
    }

    public static int toFaceValue(int deckValue){
        int convertedFaceValue = (deckValue % 13) + 1;
        if (convertedFaceValue == 1){
            convertedFaceValue = 14;
        }
        return convertedFaceValue;
    }

    public int toSuitValue(int deckValue) {
        int convertedSuitValue = deckValue / 13;
        if (deckValue % 13 !=0){
            convertedSuitValue++;
        }
        return convertedSuitValue;
    }

    public String toStringBrief(){
        String faceBrief;
        if (faceValue <=10){
             faceBrief = getFaceName();
        } else {
            faceBrief = getFaceName().substring(0,1);
        }

        String suitBrief = getSuitName().substring(0,1);
        String brief = faceBrief + suitBrief;
        return brief;
    }

    public boolean equals(Card other){
        if (deckValue != other.deckValue){
            return false;
        }
        return true;
    }




}
