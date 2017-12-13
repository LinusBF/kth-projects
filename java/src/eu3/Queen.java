package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Queen extends Chesspiece {

    protected Queen(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'Q';
    }

    @Override
    public void markReachableFields() {
        genMarkStraight(true);

        for (int i = -1 ; i <= 1; i = i + 2){
            for (int j = -1; j <= 1; j = j + 2){
                genMarkDiagonal((byte) (this.column + i), (char) (this.row + j), (i >= 0), (j >= 0), true);
            }
        }
    }

    @Override
    public void unmarkReachableFields() {
        genMarkStraight(false);

        for (int i = -1 ; i <= 1; i = i + 2){
            for (int j = -1; j <= 1; j = j + 2){
                genMarkDiagonal((byte) (this.column + i), (char) (this.row + j), (i >= 0), (j >= 0), false);
            }
        }
    }

    private void genMarkDiagonal(byte col, char row, boolean col_direction, boolean row_direction, boolean mark){
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

    private void genMarkStraight(boolean mark){

        //Mark all fields in front of and behind Queen
        for(int i = -1; i <= 1; i = i + 2){
            byte col = (byte) (this.column + i);
            while(this.board.isValidField(this.row, col)) {
                int r = this.row - Chessboard.FIRST_ROW;
                int c = col - Chessboard.FIRST_COLUMN;
                if(mark){
                    this.board.fields[r][c].mark();
                }else{
                    this.board.fields[r][c].unmark();
                }

                col = (byte) (col + i);
            }
        }

        //Mark all fields above and below Queen
        for(int i = -1; i <= 1; i = i + 2){
            char row = (char) (this.row + i);
            while(this.board.isValidField(row, this.column)) {
                int r = row - Chessboard.FIRST_ROW;
                int c = this.column - Chessboard.FIRST_COLUMN;
                if(mark){
                    this.board.fields[r][c].mark();
                }else{
                    this.board.fields[r][c].unmark();
                }

                row = (char) (row + i);
            }
        }
    }
}
