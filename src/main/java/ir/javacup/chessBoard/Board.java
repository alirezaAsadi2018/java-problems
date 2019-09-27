package ir.javacup.chessBoard;

import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < 3 * n + 1; i++) {
            for (int j = 0; j < 6 * n + 1; j++) {
                if (i % 3 == 0) {
                    if (j % 6 == 0 && i == 0)
                        System.out.print(" ");
                    else if (j % 6 == 0)
                        System.out.print("|");
                    else
                        System.out.print("_");
                }
                if (i % 3 == 1) {
                    if (j % 6 == 0)
                        System.out.print("|");
                    else
                        System.out.print(" ");
                }
                if (i % 3 == 2) {
                    if (j % 6 == 0)
                        System.out.print("|");
                    else if ((j / 6) % 2 == 1 && (i / 3) % 2 == 0 || (j / 6) % 2 == 0 && (i / 3) % 2 == 1)
                        System.out.print("x");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
