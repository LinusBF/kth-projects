import controller.Controller;
import integration.InventoryHandler;
import integration.MembershipHandler;
import utils.ConsoleLogger;
import utils.FileLogger;
import utils.PosLogger;
import view.View;

import java.io.IOException;

/**
 * Created by Linus on 2018-05-05.
 */
public class Seminar_4 {

    public static void main(String[] args) {
        InventoryHandler inventory = InventoryHandler.getInventory();
        MembershipHandler membership = new MembershipHandler();
        Controller controller = new Controller(inventory, membership);
        View view = null;

        try{
            PosLogger[] loggers = {new ConsoleLogger(), new FileLogger()};
            view = new View(controller, loggers);
        }catch (IOException e) {
            System.out.println("Logger could not be initialized, terminating...");
            System.exit(0);
        }

        while(true){
            view.POSloop();
        }
    }

}
