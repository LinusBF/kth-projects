package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Pawn extends Chesspiece {

    protected Pawn(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'P';
    }

    @Override
    public void markReachableFields() {
        byte col = (byte) (this.column + 1);
        if (this.board.isValidField (this.row, col))
        {
            int r = this.row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].mark ();
        }
    }

    @Override
    public void unmarkReachableFields() {
        byte col = (byte) (this.column + 1);
        if (this.board.isValidField (this.row, col))
        {
            int r = this.row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].mark ();
        }
    }
}
