import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
      
        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column (0-2):");
            int row = input.nextInt();
            int col = input.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("That spot is already taken. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a tie!");
                gameOver = true;
            } else {
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome to Tic Tac Toe!");
       boolean continuePlay = true;
       
       do {
       TicTacToe game = new TicTacToe();
       game.play(); 
       System.out.println("Would you like to play another round? Enter 1 if yes, 0 if no.");
       int answer = input.nextInt();
       if (answer == 0) continuePlay = false;
       } while (continuePlay);
    }
}
