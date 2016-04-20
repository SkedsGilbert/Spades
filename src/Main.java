import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int numberOfPlayers = 0;
    private static int numberOfAI = 0;
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<CardHand> players = new ArrayList<>();
    private static CardDeck deck = new CardDeck();
    private static Utils utils = new Utils();

    public static void main(String[] args) {
        boolean endOfGame = false;
        boolean endOfRound = false;

        while (endOfGame == false) {
            getPlayerInfo();
            dealCards();
            makeBets();
            while (endOfRound == false) {

                showHand(players.get(0));
                players.get(0).playCard(utils.isValidInt("Which card to play? "));
                showHand(players.get(0));


                endOfRound = true;
            }


            endOfGame = true;
        }
    }

    private static void getPlayerInfo() {
        numberOfPlayers = utils.isValidInt("Enter number of players (1-4): ");

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter player name: ");
            String playerName = reader.next();
            CardHand newPlayer = new CardHand();
            newPlayer.setPlayerName(playerName);
            players.add(newPlayer);
        }

        if (players.size() < 4) {
            numberOfAI = 4 - players.size();
            for (int i = players.size(); i < 4; i++) {
                CardHand compPlayer = new CardHand();
                compPlayer.setPlayerName(compPlayer.getCPUName(i));
                players.add(compPlayer);
                players.get(i).setAIPlayer(true);
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


        ArrayList<String> names = new ArrayList<>();
        ArrayList<Boolean> isAIPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            names.add(players.get(i).getPlayerName());
            isAIPlayers.add(players.get(i).isAIPlayer());
            players.set(i, players.get(i).sortHand());
            players.get(i).setPlayerName(names.get(i));
            players.get(i).setAIPlayer(isAIPlayers.get(i));
        }

    }

    private static void makeBets() {
        int bid;
        for (int i = 0; i < numberOfPlayers; i++) {
            bid = utils.isValidInt(players.get(i).getPlayerName() + " what is you bid? ");
            players.get(i).setBet(bid);
        }
    }
/*

    private static void testRun() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player Name: " + players.get(i).getPlayerName() + " " + players.get(i).isAIPlayer());
        }
    }
*/

    private static void showHand(CardHand cardHand) {
        System.out.println(cardHand.getPlayerName() + "'s hand: " + cardHand.toStringBrief());
    }

    private static void playCard(CardHand cardHand) {


    }

}



















