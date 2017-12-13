package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public abstract class Chesspiece {
    private char color;
    // w - white, b - black
    protected char name;
    // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
    // P – Pawn
    protected char row = 0;
    protected byte column = -1;
    protected Chessboard board;
    protected Chesspiece (char color, char name, Chessboard cb) {
        this.board = cb;
        this.color = color;
    }
    public String toString ()
    {
        return "" + color + name;
    }
    public boolean isOnBoard ()
    {
        return this.board.isValidField (row, column);
    }
    public void moveTo (char row, byte column) throws NotValidFieldException
    {
        if (!this.board.isValidField (row, column))
            throw new NotValidFieldException ("bad field: " + row + column );
        this.row = row;
        this.column = column;
        int r = row - Chessboard.FIRST_ROW;
        int c = column - Chessboard.FIRST_COLUMN;
        this.board.fields[r][c].put (this);
    }
    public void moveOut () {}
    public abstract void markReachableFields ();
    public abstract void unmarkReachableFields ();

}
