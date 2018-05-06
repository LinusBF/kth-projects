import controller.Controller;
import view.View;

/**
 * Created by Linus on 2018-05-05.
 */
public class Seminar_3 {

    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);

        while(true){
            view.POSloop();
        }
    }

}
