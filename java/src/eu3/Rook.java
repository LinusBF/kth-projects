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
        genMark(true);
    }

    @Override
    public void unmarkReachableFields() {
        genMark(false);
    }

    private void genMark(boolean mark){
        byte col = (byte) (this.column + 1);

        //Mark all fields in front of and behind Rook
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

        //Mark all fields above and below Rook
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
