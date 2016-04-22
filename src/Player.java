import java.util.ArrayList;

/**
 * Created by Jsin on 4/15/2016.
 */
public class Player extends CardHand{
    private String playerName;
    private int score = 0;
    private int bet = 0;
    private boolean isAIPlayer = false;
    private static Utils utils = new Utils();
    private ArrayList<CardHand> cards = new ArrayList<>();

    public Player() {
        playerName = "";
        score = 0;
    }

    public Player(int name) {
        playerName = makeName(name);
        score = 0;
        isAIPlayer = true;
    }

    public Player(String name) {
        playerName = name;
        score = 0;
    }

    public boolean isAIPlayer() {
        return isAIPlayer;
    }

    public void setAIPlayer(boolean AIPlayer) {
        isAIPlayer = AIPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCPUName(int nameNumber) {
        return makeName(nameNumber);
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected String makeName(int selectedNumber) {
        String nameAI = "";
//
        switch (selectedNumber) {
            case 1:
                nameAI = "Sara";
                break;
            case 2:
                nameAI = "Bruce";
                break;
            case 3:
                nameAI = "Emma";
                break;
            case 4:
                nameAI = "Noah";
                break;
            case 5:
                nameAI = "Olivia";
                break;
            case 6:
                nameAI = "Ava";
                break;
            case 7:
                nameAI = "Jayden";
                break;
            case 8:
                nameAI = "Ethan";
                break;
            case 9:
                nameAI = "Isabella";
                break;
            case 10:
                nameAI = "Hannah";
                break;
        }
        return nameAI;
    }

    public void showHand(CardHand cardHand) {
        System.out.println(getPlayerName() + "'s hand: " + cardHand.toStringBrief() );
    }

    public void makeBets(CardHand cardHand) {
        int bid;
        if (isAIPlayer()) {
            aiBet();
        } else {
            showHand(cardHand);
            bid = utils.isValidInt(getPlayerName() + " what is your bid? ");
            setBet(bid);
             }
    }

    public void aiBet() {
        int betAmount = 0;
        for (Card card : getCards()) {

            if (card.getFaceName().equalsIgnoreCase("jack")) {
                betAmount++;
            } else if (card.getFaceName().equalsIgnoreCase("queen")) {
                betAmount++;
            } else if (card.getFaceName().equalsIgnoreCase("king")) {
                betAmount++;
            } else if (card.getFaceName().equalsIgnoreCase("ace")) {
                betAmount++;
            }
            
        }

        setBet(betAmount);
    }



}
























