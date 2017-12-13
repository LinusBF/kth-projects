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

    }

    @Override
    public void unmarkReachableFields() {

    }
}
