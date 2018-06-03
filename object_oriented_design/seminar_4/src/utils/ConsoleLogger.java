package utils;


/**
 * Created by Linus on 2018-05-18.
 */
public class ConsoleLogger implements PosLogger{
    @Override
    public void logErrorMessage(String msg, Exception e) {
        System.out.println(DateAndTimeUtility.getCurrentTime() + ": ERROR\n" + msg);
    }
}
