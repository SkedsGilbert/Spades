
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int numberOfPlayers = 0;
    private static int numberOfAI = 0;
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<CardHand> players = new ArrayList<>();
    private static CardDeck deck = new CardDeck();

    public static void main(String[] args) {
        boolean endOfGame = false;

        while (endOfGame == false) {
            getPlayerInfo();
            dealCards();
            makeBets();



            endOfGame = true;


        }
    }

    private static void getPlayerInfo() {

        isValid();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter player name: ");
            String playerName = reader.next();
            CardHand newPlayer = new CardHand();
            newPlayer.setPlayerName(playerName);
            players.add(newPlayer);
        }

        if (players.size() < 4) {
            numberOfAI = 4 - players.size();
            for (int i = numberOfAI; i <= 4; i++) {
                CardHand compPlayer = new CardHand();
                compPlayer.setPlayerName(compPlayer.getCPUName(i));
                players.add(compPlayer);
                players.get(i).setAIPlayer(true);
            }

        }
    }

    private static void isValid() {
        boolean isValidNumber = false;

        while (isValidNumber == false) {
            System.out.print("Enter number of players (1-4): ");
            try {
                numberOfPlayers = reader.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                isValidNumber = false;
                reader.next();
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
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(players.get(i).getPlayerName() + " what is your bid? ");
            players.get(i).setBet(reader.nextInt());
        }
    }
}



















