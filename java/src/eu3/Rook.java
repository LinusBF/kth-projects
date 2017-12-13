package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Rook extends Chesspiece {

    protected Rook(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'R';
    }

    @Override
    public void markReachableFields() {
        byte col = (byte) (this.column + 1);

        //Mark all fields in front of Rook
        while(this.board.isValidField(this.row, col)) {
            int r = this.row - Chessboard.FIRST_ROW;
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
        byte col = (byte) (this.column + 1);

        //Mark all fields in front of Rook
        while(this.board.isValidField(this.row, col)) {
            int r = this.row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].unmark();

            col++;
        }

        col = (byte) (this.column - 1);

        //Mark all fields in front of Rook
        while(this.board.isValidField(this.row, col)) {
            int r = this.row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            this.board.fields[r][c].unmark();

            col--;
        }
    }
}
