package utils;


/**
 * Created by Linus on 2018-05-18.
 */
public class ErrorHandler {
    public void showErrorMessage(String msg) {
        System.out.println(DateAndTimeUtility.getCurrentTime() + ": ERROR\n" + msg);
    }
}
