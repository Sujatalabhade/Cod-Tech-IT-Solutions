import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        printBoard(board);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char currentPlayer = 'X';
        boolean gameWon = false;

        while (true) {
            int[] move;
            if (currentPlayer == 'X') {
                move = getPlayerMove(scanner);
            } else {
                move = getComputerMove(random, board);
            }

            if (isValidMove(board, move)) {
                board[move[0]][move[1]] = currentPlayer;
                printBoard(board);

                if (checkWin(board, currentPlayer)) {
                    System.out.println(currentPlayer + " wins!");
                    gameWon = true;
                    break;
                }

                if (isBoardFull(board)) {
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void printBoard(char[][] board) {
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

    private static int[] getPlayerMove(Scanner scanner) {
        System.out.println("Enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    private static int[] getComputerMove(Random random, char[][] board) {
        System.out.println("Computer's move: ");
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(board, new int[]{row, col}));
        return new int[]{row, col};
    }

    private static boolean isValidMove(char[][] board, int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
