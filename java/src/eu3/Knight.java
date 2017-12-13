package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Knight extends Chesspiece {
    protected Knight(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'N';
    }

    @Override
    public void markReachableFields() {
        byte col = (byte) (this.column + 1);
        char row = (char) (this.row + 1);

        //Mark all fields in front of Rook
        while(this.board.isValidField(row, col)) {
            int r = row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].mark();

            col++;
        }

        col = (byte) (this.column - 1);

        //Mark all fields in front of Rook
        while(this.board.isValidField(this.row, col)) {
            int r = this.row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].mark();

            col--;
        }
    }

    @Override
    public void unmarkReachableFields() {

    }
}
