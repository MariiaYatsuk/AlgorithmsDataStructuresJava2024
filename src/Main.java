import boards.ConsoleBoard;
import game.ConsoleGame;
import player.RegularPlayer;

public class Main {
    public static void main(String[] args) {
        ConsoleBoard board = new ConsoleBoard();
        RegularPlayer player = new RegularPlayer();

        ConsoleGame game = new ConsoleGame(board, player);
        game.start();
    }
}

