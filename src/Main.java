
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int numberOfPlayers = 0;
    private static int numberOfAI =0;
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Player> cpuPlayer = new ArrayList<>();
    private  static CardHand player1 = new CardHand();
    private  static CardHand player2 = new CardHand();
    private  static CardHand player3 = new CardHand();
    private  static CardHand player4 = new CardHand();

    public static void main(String[] args) {
        boolean endOfGame = false;
        getPlayerInfo();
        CardDeck deck = new CardDeck();

        player1.setPlayerName(players.get(0).getPlayerName());

        System.out.println("PlayerName: " + player1.getPlayerName());

        while (endOfGame == false) {




            endOfGame = true;







        }
    }

    private static void getPlayerInfo() {
        System.out.print("Enter number of players: ");
        numberOfPlayers = reader.nextInt();
        while (numberOfPlayers < 1 || numberOfPlayers > 4) {
            System.out.println("Enter number of players (1-4): ");
            numberOfPlayers = reader.nextInt();
        }

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter player name: ");
            String playerName = reader.next();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player name: " + players.get(i).getPlayerName());
        }

        if (players.size() < 4) {
            numberOfAI = 4 - players.size();
            for (int i = 1; i <= numberOfAI; i++) {
                Player newPlayer = new Player(i);
                cpuPlayer.add(newPlayer);
            }
            for (int i = 0; i < cpuPlayer.size(); i++) {

                System.out.println("Player name: " + cpuPlayer.get(i).getPlayerName());
            }
        }
    }
}



















