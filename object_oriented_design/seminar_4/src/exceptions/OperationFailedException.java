package exceptions;

/**
 * Created by Linus on 2018-05-18.
 */
public class OperationFailedException extends Exception {

    /**
     * Creates a new instance representing the condition
     * described in the specified message.
     * @param message A message that describes what went wrong.
     * @param cause The Exception that caused this exception to be thrown
     */
    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
