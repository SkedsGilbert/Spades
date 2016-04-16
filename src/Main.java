
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int numberOfPlayers = 0;
    private static int numberOfAI = 0;
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<CardHand> players = new ArrayList<>();
    private static ArrayList<Player> cpuPlayer = new ArrayList<>();
    private static CardDeck deck = new CardDeck();

    public static void main(String[] args) {
        boolean endOfGame = false;
        getPlayerInfo();
        dealCards();
        System.out.println("Player Name: " + players.get(0).getPlayerName() + " " + players.get(0).toStringBrief());
        System.out.println("Player2 Name: " + players.get(1).getPlayerName() + " " + players.get(1).toStringBrief());
        System.out.println("Player3 Name: " + players.get(2).getPlayerName() + " " + players.get(2).toStringBrief());
        System.out.println("Player4 Name: " + players.get(3).getPlayerName() + " " + players.get(3).toStringBrief());


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
            CardHand newPlayer = new CardHand();
            newPlayer.setPlayerName(playerName);
            players.add(newPlayer);
        }

        if (players.size() < 4) {
            numberOfAI = 4 - players.size();
            for (int i = 1; i <= numberOfAI; i++) {
                CardHand compPlayer = new CardHand();
                compPlayer.setPlayerName(compPlayer.getCPUName(i));
                players.add(compPlayer);
            }
            for (int i = 0; i < cpuPlayer.size(); i++) {

                System.out.println("Player name: " + cpuPlayer.get(i).getPlayerName());
            }
        }
    }

    private static void dealCards() {
        for (int i = 0; i < deck.getSize() || i >= deck.getSize(); i++) {
            if (deck.getSize() == 0) {
                break;
            }
            players.get(0).addCard(deck.dealCard());
            if (deck.getSize() == 0) {
                break;
            }
            players.get(1).addCard(deck.dealCard());
            if (deck.getSize() == 0) {
                break;
            }
            players.get(2).addCard(deck.dealCard());
            if (deck.getSize() == 0) {
                break;
            }
            players.get(3).addCard(deck.dealCard());
        }

        players.set(0, players.get(0).sortHand());
        players.set(1, players.get(1).sortHand());
        players.set(2, players.get(2).sortHand());
        players.set(3, players.get(3).sortHand());

    }
}



















