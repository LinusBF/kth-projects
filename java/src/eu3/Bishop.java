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
        for (int i = -1 ; i <= 1; i = i + 2){
            for (int j = -1; j <= 1; j = j + 2){
                genMark((byte) (this.column + i), (char) (this.row + j), (i >= 0), (j >= 0), true);
            }
        }
        /*genMark((byte) (this.column + 1), (char) (this.row + 1), true, true, true);

        genMark((byte) (this.column - 1), (char) (this.row + 1), false, true, true);

        genMark((byte) (this.column - 1), (char) (this.row - 1), false, false, true);

        genMark((byte) (this.column + 1), (char) (this.row - 1), true, false, true);*/
    }

    @Override
    public void unmarkReachableFields() {
        for (int i = -1 ; i <= 1; i = i + 2){
            for (int j = -1; j <= 1; j = j + 2){
                genMark((byte) (this.column + i), (char) (this.row + j), (i >= 0), (j >= 0), false);
            }
        }
    }

    private void genMark(byte col, char row, boolean col_direction, boolean row_direction, boolean mark){
        while(this.board.isValidField(row, col)) {
            int r = row - Chessboard.FIRST_ROW;
            int c = col - Chessboard.FIRST_COLUMN;
            if(mark){
                this.board.fields[r][c].mark();
            }else{
                this.board.fields[r][c].unmark();
            }

            if (col_direction){ col++; } else { col--; }
            if (row_direction){ row++; } else { row--; }
        }
    }
}
