import boards.ConsoleBoard;
import game.ConsoleGame;
import words.DefaultWords;
import player.RegularPlayer;
import player.AIPlayer;
import player.ChildPlayer;
import player.GodPlayer;

public class Main {
    public static void main(String[] args) {
        ConsoleBoard board = new ConsoleBoard();
        DefaultWords words = new DefaultWords();

        //RegularPlayer player = new RegularPlayer();
        // ChildPlayer player = new ChildPlayer();
         GodPlayer player = new GodPlayer();
        //AIPlayer player = new AIPlayer();

        ConsoleGame game = new ConsoleGame(board, player, words);
        game.start();
    }
}

