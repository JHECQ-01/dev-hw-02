import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame(scanner);
        game.start();
    }
}

class TicTacToeGame {
    private char[] board;
    private int winner;
    private Scanner scanner;

    public TicTacToeGame(Scanner scanner) {
        this.board = new char[9];
        this.winner = 0;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Enter box number to select. Enjoy!\n");
        clearBoard();
        while (true) {
            printBoard();
            if (checkWinner()) {
                printResult();
                break;
            }
            playerMove();
            if (checkWinner()) {
                printBoard();
                printResult();
                break;
            }
            if (!isBoardAvailable()) {
                winner = 3;
                printBoard();
                printResult();
                break;
            }
            computerMove();
            if (checkWinner()) {
                printBoard();
                printResult();
                break;
            }
        }
    }

    private void printBoard() {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private void clearBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] != ' ' && board[i * 3] == board[i * 3 + 1] && board[i * 3 + 1] == board[i * 3 + 2]) {
                winner = (board[i * 3] == 'X') ? 1 : 2;
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] != ' ' && board[i] == board[i + 3] && board[i] == board[i + 6]) {
                winner = (board[i] == 'X') ? 1 : 2;
                return true;
            }
        }
        if (board[0] != ' ' && board[0] == board[4] && board[0] == board[8]) {
            winner = (board[0] == 'X') ? 1 : 2;
            return true;
        }
        if (board[2] != ' ' && board[2] == board[4] && board[2] == board[6]) {
            winner = (board[2] == 'X') ? 1 : 2;
            return true;
        }
        return false;
    }

    private void printResult() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by creative6ear. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by creative6ear. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by creative6ear. Thanks for playing!");
        }
    }

    private void playerMove() {
        while (true) {
            System.out.print("Enter your move (1-9): ");
            int input = scanner.nextInt();
            if (input > 0 && input < 10 && board[input - 1] == ' ') {
                board[input - 1] = 'X';
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isBoardAvailable() {
        for (char cell : board) {
            if (cell == ' ') {
                return true;
            }
        }
        return false;
    }

    private void computerMove() {
        while (true) {
            int rand = (int) (Math.random() * 9);
            if (board[rand] == ' ') {
                board[rand] = 'O';
                break;
            }
        }
    }
}
