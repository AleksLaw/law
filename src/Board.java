public class Board {

    int sizeBoard;
    char[][] field;

    public Board(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        field=new char [sizeBoard][sizeBoard];
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
}
