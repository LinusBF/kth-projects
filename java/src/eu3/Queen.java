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

    }

    @Override
    public void unmarkReachableFields() {

    }
}
