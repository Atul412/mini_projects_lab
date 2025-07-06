import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the board
        initializeBoard();

        // Who starts?
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + "'s turn.");

            int row, col;
            while (true) {
                System.out.print("Enter row (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = scanner.nextInt() - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        System.out.println("Game Over!");
        scanner.close();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        return board[row][col] == ' ';
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
