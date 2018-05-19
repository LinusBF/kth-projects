package exceptions;

/**
 * Created by Linus on 2018-05-18.
 */
public class DatabaseFailureException extends RuntimeException {
    /**
     * Thrown when something goes wrong while performing an
     * operation in the <code>InventoryHandler</code>.
     */
    public DatabaseFailureException() {
        super("Database is not responding.");
    }
}
