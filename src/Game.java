public interface Game {
    void start(); // Start the game
    void play();  // Main gameplay loop
    void printBoard(); // Print the game board
    boolean checkWinner(); // Check for win/lose conditions
}