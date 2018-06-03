package controller;

import integration.InventoryHandler;
import integration.MembershipHandler;
import integration.ItemDTO;
import model.DiscountDTO;
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
        inventory = InventoryHandler.getInventory();
        membership = new MembershipHandler();
        controller = new Controller(inventory, membership);
        controller.startSale();
    }

    @After
    public void tearDown() throws Exception {
        inventory = null;
        membership = null;
        controller = null;
    }

    @Test
    public void testEnterItem() throws Exception {
        ItemDTO expectedItem = inventory.getItemInfo(1);

        ItemDTO item = controller.enterItem(1, 2);
        assertEquals("Doesn't return the correct item", expectedItem, item);
    }

    @Test
    public void testCustomerDiscount() throws Exception {
        controller.enterItem(1, 1);
        controller.enterItem(2, 1);
        controller.enterItem(3, 1);

        double DISCOUNT_1 = 15;

        double totalBeforeDiscount = controller.getCurrentTotal();
        double expectedTotalAfterDiscount = totalBeforeDiscount * ((100 - DISCOUNT_1) / 100);

        double totalAfterDiscount = controller.getCustomerDiscount(1);

        assertEquals("Discount is not applied correctly", expectedTotalAfterDiscount, totalAfterDiscount, 0.001);
    }

    @Test
    public void testCompletePayment() throws Exception {
        controller.enterItem(1, 4);
        controller.enterItem(2, 2);
        controller.enterItem(3, 1);

        double BIG_PAYMENT = 500;
        controller.completePayment(BIG_PAYMENT);

        //Should't be enough stock left to remove the following quantity of items
        boolean removedStock = inventory.removeFromStock(1, 7);
        assertFalse("Stock has not been removed correctly", removedStock);
        boolean removedStock3 = inventory.removeFromStock(3, 10);
        assertFalse("Stock has not been removed correctly", removedStock3);
    }
}
