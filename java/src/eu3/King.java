package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class King extends Chesspiece {
    protected King(char color, char name, Chessboard cb) {
        super(color, name, cb);
        this.name = 'K';
    }

    @Override
    public void markReachableFields() {

    }

    @Override
    public void unmarkReachableFields() {

    }
}
