
/**
 * Created by Jsin on 4/15/2016.
 */
public class Player {
    private String playerName;
    private int score = 0;
    private int bet = 0;

    public Player() {
        playerName = "";
        score = 0;
    }

    public Player(int name) {
        playerName = makeName(name);
        score = 0;
    }

    public Player(String name) {
        playerName = name;
        score = 0;
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

    private String makeName(int selectedNumber) {
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
}
























