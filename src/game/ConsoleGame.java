package game;

import boards.Board;
import player.AIPlayer;
import player.Player;
import words.DefaultWords;
import words.Words;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleGame implements Game{
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Board someBoard;
    private final Words words;
    private final Player player;
    private String theWord;
    private String notUsed;


    public ConsoleGame(Board someBoard, Player player, Words words){
    this.someBoard = someBoard;
    this.player = player;
    this.words = words;
    }

    @Override
    public void start() {
        initializeGame();
        while (true) {
            System.out.println("Welcome to the game Word Guess!");
            System.out.println("Press n for new game");
            System.out.println("Press q to quit");
            System.out.println("Press / to return to the menu");

            String menu = SCANNER.nextLine();

            if (menu.equals("q")) {
                System.out.println("Exiting...");
                break;
            } else if (menu.equals("n")) {
                initializeGame();
                play();
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private void initializeGame() {
        theWord =  words.provideWord();
        someBoard.initializeBoard(theWord);
        notUsed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    @Override
    public void play() {
        while (someBoard.checkWinner(theWord, player)) {
            someBoard.printBoard(player);
            System.out.println("Not used letters: " + notUsed);
            System.out.println("Enter a letter ");

            char letter;
            if (player instanceof AIPlayer) {
                letter = ((AIPlayer) player).guessLetter(notUsed);
                System.out.println("AI player guessed: " + letter);
            } else {
                String input = new Scanner(System.in).nextLine().toUpperCase();

                if (input.equals("/")) { // Перехід у меню
                    System.out.println("Returning to menu...");
                    return;
                }

                if (!Pattern.matches("[A-Z]", input)) {
                    System.out.println("This is not a single letter");
                    continue;
                }
                letter = input.charAt(0);
            }

            if (!notUsed.contains(String.valueOf(letter))) {
                System.out.println("Letter already used");
                continue;
            }

            notUsed = notUsed.replace(String.valueOf(letter), ".");
            boolean found = someBoard.updateBoard(theWord, letter);

            if (!found) {
                player.decreaseLife();
            }
        }
    }
}
