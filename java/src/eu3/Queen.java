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
                genMarkDiagonal((byte) (this.column + i), (char) (this.row + j), false);
            }
        }
    }

    @Override
    public void unmarkReachableFields() {
        genMarkStraight(false);

        for (int i = -1 ; i <= 1; i = i + 2){
            for (int j = -1; j <= 1; j = j + 2){
                genMarkDiagonal((byte) (this.column + i), (char) (this.row + j), false);
            }
        }
    }

    private void genMarkDiagonal(byte col, char row, boolean mark){
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

    private void genMarkStraight(boolean mark){
        byte col = (byte) (this.column + 1);

        //Mark all fields in front of and behind Queen
        for(int i = -1; i <= 1; i = i + 2){
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

        char row = (char) (this.row + 1);

        //Mark all fields above and below Queen
        for(int i = -1; i <= 1; i = i + 2){
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
