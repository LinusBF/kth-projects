package exceptions;

/**
 * Created by Linus on 2018-05-18.
 */
public class DatabaseFailureException extends Exception {
    public DatabaseFailureException() {
        super("Database is not responding");
    }
}
