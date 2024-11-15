import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame implements Game {
    private static final String[] WORDS = {"EVEREST", "CINEMA", "APEX", "CLIMAX", "WISDOM", "PREMIERE", "HEREDITARY", "PRIMARY", "SEQUEL", "CUBE"};
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private String theWord;
    private ArrayList<String> board;
    private int life;
    private String notUsed;

    public WordGuessGame() {
        this.board = new ArrayList<>();
    }

    @Override
    public void start() {
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
        board.clear();
        for (int i = 0; i < theWord.length(); i++) {
            board.add("-");
        }
        life = 8;
        notUsed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    @Override
    public void play() {
        while (checkWinner()) {
            printBoard();
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
            boolean found = false;
            for (int i = 0; i < theWord.length(); i++) {
                if (theWord.charAt(i) == letter) {
                    board.set(i, String.valueOf(letter));
                    found = true;
                }
            }

            if (!found) {
                life--;
            }
        }
    }

    @Override
    public void printBoard() {
        for (String ch : board) {
            System.out.print(ch);
        }
        System.out.println(" " + life + " lives left");
        System.out.println("Not used letters: " + notUsed);
    }

    @Override
    public boolean checkWinner() {
        StringBuilder currentWord = new StringBuilder();
        for (String ch : board) {
            currentWord.append(ch);
        }

        if (currentWord.toString().equals(theWord)) {
            System.out.println("You won!");
            System.out.println("The word was: " + theWord);
            return false;
        } else if (life == 0) {
            System.out.println("No lives left. Game Over!");
            System.out.println("The word was: " + theWord);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WordGuessGame game = new WordGuessGame();
        game.start();
    }
}
