package eu3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class ChessTest {
    public static void main(String[] args) {
        Random rand = new Random();
        Chessboard board = new Chessboard();
        Pawn pawn = new Pawn('w', 'P', board);
        Rook rook = new Rook('b', 'R', board);
        Knight knight = new Knight('w', 'N', board);
        Bishop bishop = new Bishop('b', 'B', board);
        Queen queen = new Queen('w', 'Q', board);
        King king = new King('w', 'K', board);

        Chesspiece[] chesspieces = {pawn, rook, knight, bishop, queen, king};

        System.out.println(board.toString() + "\n\n\n");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Chesspiece piece : chesspieces) {
            int row = rand.nextInt(8);
            int col = rand.nextInt(8);

            System.out.println(piece.name + ":");

            try {
                piece.moveTo((char) (Chessboard.FIRST_ROW + row), (byte) (col));
                piece.markReachableFields();
                System.out.println(board.toString() + "\n\n\n");
                piece.unmarkReachableFields();
                piece.moveOut();
            } catch (NotValidFieldException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
