package game;

import boards.Board;
import player.Player;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleGame implements Game{
    private static final String[] WORDS = {"EVEREST", "CINEMA", "APEX", "CLIMAX", "WISDOM", "PREMIERE", "HEREDITARY", "PRIMARY", "SEQUEL", "CUBE"};
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Board someBoard;
    private final Player player;
    private String theWord;
    private String notUsed;


    public ConsoleGame(Board someBoard,Player player){
    this.someBoard = someBoard;
    this.player = player;
    }

    @Override
    public void start() {
        initializeGame();
        while (true) {
            System.out.println("Welcome to the game Word Guess!");
            System.out.println("Press n for new game");
            System.out.println("Press q to quit");
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
        theWord = WORDS[RANDOM.nextInt(WORDS.length)];
        someBoard.initializeBoard(theWord);
        notUsed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    @Override
    public void play() {
        while (someBoard.checkWinner(theWord,player)) {
            someBoard.printBoard(player);
            System.out.println("Not used letters: " + notUsed);
            System.out.println("Enter a letter (A-Z):");

            String input = SCANNER.nextLine().toUpperCase();

            if (!Pattern.matches("[A-Z]", input)) {
                System.out.println("This is not a single letter");
                continue;
            }

            char letter = input.charAt(0);

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
