package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Bishop extends Chesspiece {

    protected Bishop(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'B';
    }

    @Override
    public void markReachableFields() {
        genMark((byte) (this.column + 1), (char) (this.row + 1), true);

        genMark((byte) (this.column - 1), (char) (this.row + 1), true);

        genMark((byte) (this.column - 1), (char) (this.row - 1), true);

        genMark((byte) (this.column + 1), (char) (this.row - 1), true);
    }

    @Override
    public void unmarkReachableFields() {
        genMark((byte) (this.column + 1), (char) (this.row + 1), false);

        genMark((byte) (this.column - 1), (char) (this.row + 1), false);

        genMark((byte) (this.column - 1), (char) (this.row - 1), false);

        genMark((byte) (this.column + 1), (char) (this.row - 1), false);
    }

    private void genMark(byte col, char row, boolean mark){
        while(this.board.isValidField(row, col)) {
            int r = row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            if(mark){
                this.board.fields[r][c].mark();
            }else{
                this.board.fields[r][c].unmark();
            }

            col++;
            row--;
        }
    }
}
