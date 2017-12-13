package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class ChessTest {
    public static void main(String[] args) {
        Chessboard board = new Chessboard();
        Pawn pawn = new Pawn('w', 'P', board);
        Rook rook = new Rook('b', 'R', board);
        Knight knight = new Knight('w', 'N', board);
        Bishop bishop = new Bishop('b', 'B', board);
        Queen queen = new Queen('w', 'Q', board);
        King king = new King('w', 'K', board);
    }
}
