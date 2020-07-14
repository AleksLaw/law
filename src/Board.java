public class Board {

    int sizeBoard;
    char[][] field;

    public Board(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        field = new char[sizeBoard][sizeBoard];
    }

    public void createBoard() {
        for (int row = 0; row < sizeBoard; row++)
            for (int col = 0; col < sizeBoard; col++)
                field[row][col] = CharsTicTac.Empty.getSim();
    }

    public void printBoard() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++)
                System.out.print(field[row][col] + " ");
            System.out.println();
        }
    }

    boolean isBoardFull() {
        for (int row = 0; row < field.length; row++)
            for (int col = 0; col <field.length; col++)
                if (field[row][col] == CharsTicTac.Empty.getSim())
                    return false;
        return true;
    }

    boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x >= sizeBoard || y >= sizeBoard)
            return true;
        return field[y][x] != CharsTicTac.Empty.getSim();
    }
}
