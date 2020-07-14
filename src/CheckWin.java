public class CheckWin {

    boolean validate(char dot, int sizeBoard) {

        if (sizeBoard == 3) {
            for (int i = 0; i < TicTac.board.sizeBoard; i++)
                if ((TicTac.board.field[i][0] == dot && TicTac.board.field[i][1] == dot && TicTac.board.field[i][2] == dot)
                        || (TicTac.board.field[0][i] == dot && TicTac.board.field[1][i] == dot && TicTac.board.field[2][i] == dot))
                    return true;
            if ((TicTac.board.field[0][0] == dot && TicTac.board.field[1][1] == dot && TicTac.board.field[2][2] == dot)
                    || (TicTac.board.field[2][0] == dot && TicTac.board.field[1][1] == dot && TicTac.board.field[0][2] == dot))
                return true;
        }
        if (sizeBoard == 4) {
            for (int i = 0; i < TicTac.board.sizeBoard; i++)
                if ((TicTac.board.field[i][0] == dot && TicTac.board.field[i][1] == dot && TicTac.board.field[i][2] == dot && TicTac.board.field[i][3] == dot)
                        || (TicTac.board.field[0][i] == dot && TicTac.board.field[1][i] == dot && TicTac.board.field[2][i] == dot && TicTac.board.field[3][i] == dot))
                    return true;
            if ((TicTac.board.field[0][0] == dot && TicTac.board.field[1][1] == dot && TicTac.board.field[2][2] == dot && TicTac.board.field[3][3] == dot)
                    || (TicTac.board.field[3][0] == dot && TicTac.board.field[2][1] == dot && TicTac.board.field[1][2] == dot && TicTac.board.field[0][3] == dot))
                return true;
        }
        if (sizeBoard == 5) {
            for (int i = 0; i < TicTac.board.sizeBoard; i++)
                if ((TicTac.board.field[i][0] == dot && TicTac.board.field[i][1] == dot && TicTac.board.field[i][2] == dot && TicTac.board.field[i][3] == dot && TicTac.board.field[i][4] == dot)
                        || (TicTac.board.field[0][i] == dot && TicTac.board.field[1][i] == dot && TicTac.board.field[2][i] == dot && TicTac.board.field[3][i] == dot) && TicTac.board.field[4][i] == dot)
                    return true;
            return (TicTac.board.field[0][0] == dot && TicTac.board.field[1][1] == dot && TicTac.board.field[2][2] == dot && TicTac.board.field[3][3] == dot && TicTac.board.field[4][4] == dot)
                    || (TicTac.board.field[4][0] == dot && TicTac.board.field[3][1] == dot && TicTac.board.field[2][2] == dot && TicTac.board.field[1][3] == dot && TicTac.board.field[0][4] == dot);
        }
        return false;
    }
}
