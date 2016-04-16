import java.util.Random;

/**
 * Created by Jsin on 4/13/2016.
 *
 * Deck values: 1 - 52 (2C - AS)
 * Face Values: 2 - 14 (2-10,J,Q,K,A)
 * Suit values: 1 - 4 (Clubs,Diamonds,Hearts,Spades)
 *
 */
public class CardDeck {

    private final String EMPTY_DECK = "Empty Deck";
    private boolean[] deck = new boolean[52];
    private int size;
    private Random random = new Random();

    public CardDeck(){
        initDeck();
    }

    private void initDeck() {
        for (int i = 0; i < 52; i++) {
            deck[i] = true;
        }
        size = 52;
    }

    public Card dealCard(){
        if (size == 0){
            return null;
        }

        int randomNumber = random.nextInt(size) + 1;
        int present = 0;
        for (int i = 0; i < 52; i++) {
            if (deck[i] == false){
                continue;
            }
            present++;
            if (present == randomNumber){
                Card card = new Card(i + 1);
                deck[i] = false;
                size--;
                return card;
            }
        }
        return null;
    }

    public CardHand dealHand(int handSize){
        if (handSize <= 0 || handSize > 52){
            System.out.println("Invalid hand size");
        }

        if (handSize > size){
            return null;
        }

        CardHand hand = new CardHand();
        for (int i = 0; i < handSize; i++) {
            hand.addCard(dealCard());
        }
        return hand;
    }

    public int getSize(){
        return size;
    }

    public void resetDeck(){
        initDeck();
    }

    public String shortString(){
        if (getSize() == 0 ){
            return EMPTY_DECK;
        }

        StringBuilder shortString = new StringBuilder("");
        for (int i = 0; i < 52; i++) {
            if (deck[i]){
                Card card = new Card(i + 1);
                shortString.append(card.toStringBrief());
                shortString.append(" ");
            }
        }
        return shortString.toString();
    }

}






















