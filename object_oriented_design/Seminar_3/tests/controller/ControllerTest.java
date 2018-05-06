package controller;

import integration.InventoryHandler;
import integration.MembershipHandler;
import integration.ItemDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Linus on 2018-05-06.
 */
public class ControllerTest {
    private InventoryHandler inventory;
    private MembershipHandler membership;
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        inventory = new InventoryHandler();
        membership = new MembershipHandler();
        controller = new Controller();
    }

    @After
    public void tearDown() throws Exception {
        inventory = null;
        membership = null;
        controller = null;
    }

    @Test
    public void testCompleteSale() throws Exception {
        controller.startSale();

        ItemDTO expectedItem = inventory.getItemInfo(1);
        ItemDTO expectedItem2 = inventory.getItemInfo(2);
        ItemDTO expectedItem3 = inventory.getItemInfo(3);

        ItemDTO item = controller.enterItem(1, 4);
        assertEquals("Doesn't return the correct item", expectedItem, item);
        ItemDTO item2 = controller.enterItem(2, 2);
        assertEquals("Doesn't return the correct item", expectedItem2, item2);
        ItemDTO item3 = controller.enterItem(3, 1);
        assertEquals("Doesn't return the correct item", expectedItem3, item3);

        controller.completeSale();

        //Should't be enough stock left to remove the following quantity of items
        boolean removedStock = inventory.removeFromStock(1, 7);
        assertEquals("Stock has not been removed correctly", false, removedStock);
        boolean removedStock2 = inventory.removeFromStock(1, 9);
        assertEquals("Stock has not been removed correctly", false, removedStock2);
        boolean removedStock3 = inventory.removeFromStock(1, 10);
        assertEquals("Stock has not been removed correctly", false, removedStock3);
    }
}
