package boards;

import player.Player;

import java.util.ArrayList;

public class ConsoleBoard implements Board{
    private final ArrayList<String> board = new ArrayList<>();

    public ConsoleBoard() {}
    public void initializeBoard(String theWord){
        board.clear();
        for (int i = 0; i < theWord.length(); i++) {
            board.add("-");
        }
    }
    @Override
    public void printBoard(Player player) {
        for (String ch : board) {
            System.out.print(ch);
        }
        System.out.println(" " + player.getLifes() + " lives left");
        //System.out.println("Not used letters: " + notUsed);
    }

    public boolean checkWinner(String theWord,Player player) {
        StringBuilder currentWord = new StringBuilder();
        for (String ch : board) {
            currentWord.append(ch);
        }

        if (currentWord.toString().equals(theWord)) {
            System.out.println("You won!");
            System.out.println("The word was: " + theWord);
            return false;
        } else if (player.getLifes() == 0) {
            System.out.println("No lives left. game.Game Over!");
            System.out.println("The word was: " + theWord);
            return false;
        }
        return true;
    }

    public boolean updateBoard(String theWord, char letter){
        boolean found = false;
        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.charAt(i) == letter) {
                board.set(i, String.valueOf(letter));
                found = true;
            }
        }
        return found;
    }
}
