import java.util.*;
import java.util.Collections;

/**
 * Created by Jsin on 4/11/2016.
 */
public class CardHand extends Player {
    private final String EMPTY_HAND = "Empty Hand";
    private ArrayList<Card> cards = new ArrayList<>();

    public CardHand() {

    }

    public CardHand(int[] deckValues) {
        for (int i = 0; i < deckValues.length; i++) {
            Card card = new Card(deckValues[i]);
            cards.add(card);
        }
    }

    public CardHand(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            Card card = new Card(cards[i].getDeckValue());
            this.cards.add(card);
        }
    }

    public CardHand(ArrayList<Card> cards) {
        for (Card card : cards) {
            Card newCard = new Card(card.getDeckValue());
            this.cards.add(newCard);
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCard(int deckValue) {
        Card card = new Card(deckValue);
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public boolean hasDeckValue(int deckValue) {
        for (Card card : cards) {
            if (card.getDeckValue() == deckValue) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFaceValue(int faceValue) {
        for (Card card : cards) {
            if (card.getFaceValue() == faceValue) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSuitValue(int suitValue) {
        for (Card card : cards) {
            if (card.getSuitValue() == suitValue) {
                return true;
            }
        }
        return false;
    }

    public Card playCardAt(int index) {
        int sizeOfHand = cards.size();
        if (index > sizeOfHand - 1) {
            return null;
        }

        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public Card playCard(int deckValue) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (card.getDeckValue() == deckValue) {
                Card playCard = new Card(deckValue);
                cards.remove(i);
                return playCard;
            }
        }
        return null;
    }

    public String toStringBrief() {
        if (cards.isEmpty()) {
            return EMPTY_HAND;
        }

        StringBuilder shortString = new StringBuilder("");
        for (Card card : cards) {
            shortString.append(card.toStringBrief());
            shortString.append(" ");
        }

        return shortString.toString().trim();
    }

    public CardHand sortHand() {
        ArrayList<Integer> newHand = new ArrayList<>();
        CardHand sortedHand = new CardHand();
        for (Card card : cards) {
            newHand.add(card.getDeckValue());
        }

        Collections.sort(newHand);

        for (Integer aNewHand : newHand) {
            sortedHand.addCard(aNewHand);
        }

        return sortedHand;
    }

}


















