import java.util.Random;
import java.util.Scanner;

public class TicTac {
    Random random;
    Scanner scanner;
    Board board;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board size");

        int i = scanner.nextInt();
        while (i < 3 || i > 5) {
            System.out.println("Enter board size 3, 4 or 5");
            i = scanner.nextInt();
        }
        Board board = new Board(i);
        board.createBoard();
        board.printBoard();


        TicTac ticTac = new TicTac(board);
        ticTac.game();
    }

    TicTac(Board board) {
        random = new Random();
        scanner = new Scanner(System.in);
        this.board = board;
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.." + board.sizeBoard + "):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isValidCell(x, y));
        board.field[y][x] = CharsTicTac.X.getSim();
    }

    boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x >= board.sizeBoard || y >= board.sizeBoard)
            return true;
        return board.field[y][x] != CharsTicTac.Empty.getSim();
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(board.sizeBoard);
            y = random.nextInt(board.sizeBoard);
        } while (isValidCell(x, y));
        board.field[y][x] = CharsTicTac.O.getSim();
    }

    boolean checkWin(char dot, int sizeBoard) {

        if (sizeBoard == 3) {
            for (int i = 0; i < board.sizeBoard; i++)
                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot)
                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot))
                    return true;
            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot)
                    || (board.field[2][0] == dot && board.field[1][1] == dot && board.field[0][2] == dot))
                return true;
        }
        if (sizeBoard == 4) {
            for (int i = 0; i < board.sizeBoard; i++)
                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot && board.field[i][3] == dot)
                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot && board.field[3][i] == dot))
                    return true;
            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot && board.field[3][3] == dot)
                    || (board.field[3][0] == dot && board.field[2][1] == dot && board.field[1][2] == dot && board.field[0][3] == dot))
                return true;
        }
        if (sizeBoard == 5) {
            for (int i = 0; i < board.sizeBoard; i++)
                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot && board.field[i][3] == dot && board.field[i][4] == dot)
                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot && board.field[3][i] == dot) && board.field[4][i] == dot)
                    return true;
            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot && board.field[3][3] == dot && board.field[4][4] == dot)
                    || (board.field[4][0] == dot && board.field[3][1] == dot && board.field[2][2] == dot && board.field[1][3] == dot && board.field[0][4] == dot))
                return true;
        }
        return false;
    }
//    boolean checkWin(char dot, int sizeBoard) {
//        if (sizeBoard == 3) {
//            for (int i = 0; i < board.sizeBoard; i++)
//                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot)
//                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot))
//                    return true;
//            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot)
//                    || (board.field[2][0] == dot && board.field[1][1] == dot && board.field[0][2] == dot))
//                return true;
//        }
//        if (sizeBoard == 4) {
//            for (int i = 0; i < board.sizeBoard; i++)
//                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot && board.field[i][3] == dot)
//                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot && board.field[3][i] == dot))
//                    return true;
//            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot && board.field[3][3] == dot)
//                    || (board.field[3][0] == dot && board.field[2][1] == dot && board.field[1][2] == dot && board.field[0][3] == dot))
//                return true;
//        }
//        if (sizeBoard == 5) {
//            for (int i = 0; i < board.sizeBoard; i++)
//                if ((board.field[i][0] == dot && board.field[i][1] == dot && board.field[i][2] == dot && board.field[i][3] == dot && board.field[i][4] == dot)
//                        || (board.field[0][i] == dot && board.field[1][i] == dot && board.field[2][i] == dot && board.field[3][i] == dot) && board.field[4][i] == dot)
//                    return true;
//            if ((board.field[0][0] == dot && board.field[1][1] == dot && board.field[2][2] == dot && board.field[3][3] == dot && board.field[4][4] == dot)
//                    || (board.field[4][0] == dot && board.field[3][1] == dot && board.field[2][2] == dot && board.field[1][3] == dot && board.field[0][4] == dot))
//                return true;
//        }
//        return false;
//    }

    boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (board.field[row][col] == CharsTicTac.Empty.getSim())
                    return false;
        return true;
    }

    void game() {
        board.createBoard();
        while (true) {
            turnHuman();
            if (checkWin(CharsTicTac.X.getSim(), board.sizeBoard)) {
                System.out.println("You WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAI();
            board.printBoard();
            if (checkWin(CharsTicTac.O.getSim(), board.sizeBoard)) {
                System.out.println("Comp WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("Game over.");
        board.printBoard();
    }

}
