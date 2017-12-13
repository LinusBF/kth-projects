package eu3;

/**
 * Created by Linus Bein Fahlander on 2017-12-13.
 */
public class NotValidFieldException extends Exception {
    public NotValidFieldException() {
    }

    public NotValidFieldException(String message) {
        super(message);
    }

    public NotValidFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidFieldException(Throwable cause) {
        super(cause);
    }

    public NotValidFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
