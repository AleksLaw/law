import java.util.Random;
import java.util.Scanner;

public class TicTac {
    Random random;
    static Board board;
    static Scanner scanner= new Scanner(System.in);

    TicTac(Board board) {
        random = new Random();
        scanner = new Scanner(System.in);
        TicTac.board = board;
    }

    public static void main(String[] args) {

        System.out.println("Введите размер доски");

        int i;
        do {
            System.out.println("Введите число от  3 до 5");
            i = getInt();
        } while (i < 3 || i > 5);

        Board board = new Board(i);
        board.createBoard();
        board.printBoard();

        TicTac ticTac = new TicTac(board);
        ticTac.game();
    }

    private static int getInt() {
        String i;
        int s = 0;

        do {
            i = scanner.next();
            try {
                s = Integer.parseInt(i);
                return s;
            } catch (Exception e) {
                System.out.println("Вы ввели не число");
            }
        } while (true);
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Введите поле для хода X и Y (от 1 до" + board.sizeBoard + " каждую координату сновой строки):");
            x = getInt() - 1;
            y = getInt() - 1;
        } while (board.isValidCell(x, y));
        board.field[y][x] = CharsTicTac.X.getSim();
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(board.sizeBoard);
            y = random.nextInt(board.sizeBoard);
        } while (board.isValidCell(x, y));
        board.field[y][x] = CharsTicTac.O.getSim();
    }

    void game() {
        CheckWin checkWin = new CheckWin();
        board.createBoard();
        while (true) {
            turnHuman();
            if (checkWin.validate(CharsTicTac.X.getSim(), board.sizeBoard)) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (board.isBoardFull()) {
                System.out.println("Ничья!");
                break;
            }
            turnAI();
            board.printBoard();
            if (checkWin.validate(CharsTicTac.O.getSim(), board.sizeBoard)) {
                System.out.println("Комп выиграл!");
                break;
            }
            if (board.isBoardFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Игра окончена.");
        board.printBoard();
    }

}
