package boards;

import player.Player;

public interface Board {
    public void printBoard(Player player);
    public void initializeBoard(String theWord);

    boolean checkWinner(String theWord,Player player);
    boolean updateBoard(String theWord,char letter);
}
