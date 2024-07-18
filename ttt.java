package prathuysha;

import java.util.Scanner;

public class ttt {
    

    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char currentPlayer = PLAYER_X;
    private static char[][] board = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (checkWinner()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameRunning = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameRunning = false;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("This move is not valid.");
            }
        }
        scanner.close();
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private static boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}