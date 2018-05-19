package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by Linus on 2018-05-18.
 */
public class SaleLogger {
    private static final String LOG_FILE = "point_of_sale";
    private PrintWriter logFile;

    public SaleLogger() throws IOException{
        logFile = new PrintWriter(new FileWriter(LOG_FILE+"-"+DateAndTimeUtility.getTimeStamp()+".log"),true);
    }

    public void logException(Exception exc){
        String logEntry = DateAndTimeUtility.getCurrentTime() + ": Exception was thrown: " + exc.getMessage();
        if (exc.getCause() != null){
            logEntry += " Cause: " + exc.getCause().getMessage();
        }
        logFile.println(logEntry);
    }
}
