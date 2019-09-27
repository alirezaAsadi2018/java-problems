package ir.javacup.tictactoe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] boardGame = new String[][]{{"-", "X", "O"}, {"X", "-", "X"}, {"-", "O", "O"}};
        for (String[] strings : boardGame) {
            System.out.println(Arrays.toString(strings));
        }
        IBoard board = () -> boardGame;
        Player player = new Player(board, PlayerMark.X);
        System.out.println(player.isWinner());
        System.out.print(player.move().getRow() + " ");
        System.out.println(player.move().getCol());
    }
}
