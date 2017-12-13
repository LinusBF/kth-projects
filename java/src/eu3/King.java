package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class King extends Chesspiece {
    protected King(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'K';
    }

    @Override
    public void markReachableFields() {
        for (int i = -1 ; i <= 1; i++){
            byte col = (byte) (this.column + i);
            for (int j = -1; j <= 1; j++){
                char row = (char) (this.row + j);

                if (this.board.isValidField (row, col))
                {
                    int r = row - Chessboard.FIRST_ROW;
                    int c = col - Chessboard.FIRST_COLUMN;
                    this.board.fields[r][c].mark ();
                }
            }
        }
    }

    @Override
    public void unmarkReachableFields() {
        for (int i = -1 ; i <= 1; i++){
            byte col = (byte) (this.column + i);
            for (int j = -1; j <= 1; j++){
                char row = (char) (this.row + j);

                if (this.board.isValidField (row, col))
                {
                    int r = row - Chessboard.FIRST_ROW;
                    int c = col - Chessboard.FIRST_COLUMN;
                    this.board.fields[r][c].unmark ();
                }
            }
        }
    }
}
