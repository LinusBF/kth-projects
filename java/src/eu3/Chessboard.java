package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class Chessboard {

    public static class Field
    {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field (char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put (Chesspiece piece) {
            this.piece = piece;
        }

        public Chesspiece take () {
            Chesspiece piece = this.piece;
            this.piece = null;
            return piece;
        }

        public void mark () {
            this.marked = true;
        }

        public void unmark () {
            this.marked = false;
        }

        public String toString ()
        {
            String s = (marked)? "xx" : "--";
            return (piece == null)? s : piece.toString ();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 0;
    public Field[][] fields;

    public Chessboard () {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString () {
        char row = 0;
        byte column = 0;
        String output = "CHESS:\n";
        output += "\\" + "\t1\t2\t3\t4\t5\t6\t7\t8\n";

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            output += row + "\t";

            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                output += this.fields[r][c].toString() + "\t";
            }
            output += "\n";
        }

        return output;
    }

    public boolean isValidField (char row, byte column) {
        if ((int) row < 97 || (int) row > 122 ){
            return false;
        }

        if(column > 7 || column < 0){
            return false;
        }

        try{
            if (this.fields[row - FIRST_ROW][column].piece != null){
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

        return true;
    }
}
