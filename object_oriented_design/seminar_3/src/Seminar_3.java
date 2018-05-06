import controller.Controller;
import integration.InventoryHandler;
import integration.MembershipHandler;
import view.View;

/**
 * Created by Linus on 2018-05-05.
 */
public class Seminar_3 {

    public static void main(String[] args) {
        InventoryHandler inventory = new InventoryHandler();
        MembershipHandler membership = new MembershipHandler();
        Controller controller = new Controller(inventory, membership);
        View view = new View(controller);

        while(true){
            view.POSloop();
        }
    }

}
