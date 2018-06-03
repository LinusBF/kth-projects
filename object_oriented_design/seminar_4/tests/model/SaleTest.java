package model;

import integration.InventoryHandler;
import integration.ItemDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

/**
 * Created by Linus on 2018-05-06.
 */
public class SaleTest {
    private InventoryHandler inventory;
    private DiscountDTO discount25;
    private DiscountDTO discount15;
    private Sale sale;
    private Sale sale2;
    private static final double TAX = 25.7;

    @Before
    public void setUp() throws Exception {
        discount25 = new DiscountDTO(25, "2018-07-20");
        discount15 = new DiscountDTO(15, "2018-07-25");
        inventory = InventoryHandler.getInventory();
        sale = new Sale();
        sale2 = new Sale();
    }

    @After
    public void tearDown() throws Exception {
        discount25 = null;
        discount15 = null;
        inventory = null;
        sale = null;
        sale2 = null;
    }

    @Test
    public void testAddItem() throws Exception {
        ItemDTO testItem = inventory.getItemInfo(1);
        sale.addToSale(testItem, 1);
        Map<ItemDTO, Integer> items = sale.getItems();
        assertTrue("Item has not been added", items.containsKey(testItem));
        assertEquals("Item does not have the correct quantity", 1, (int) items.get(testItem));
        int size = items.size();
        assertEquals("There are more than one item in the basket", 1, size);
    }

    @Test
    public void testApplyDiscount() throws Exception {
        ItemDTO testItem = inventory.getItemInfo(1);
        sale.addToSale(testItem, 1);
        sale2.addToSale(testItem, 1);
        double amountToPay = sale.getTotalWithTax();
        double amountToPay2 = sale2.getTotalWithTax();

        assertEquals("Sales with same items doesn't have same price", amountToPay, amountToPay2, 0.001);

        double expectedAmountToPay = amountToPay * ((100 - discount15.getPercentage()) / 100);
        double expectedAmountToPay2 = amountToPay2 * ((100 - discount25.getPercentage()) / 100);
        sale.applyDiscount(discount15);
        sale2.applyDiscount(discount25);
        double newAmountToPay = sale.getTotalWithTax();
        double newAmountToPay2 = sale2.getTotalWithTax();

        assertEquals("Discount has not been applied correctly", expectedAmountToPay, newAmountToPay, 0.001);
        assertEquals("Discount has not been applied correctly", expectedAmountToPay2, newAmountToPay2, 0.001);
    }

    @Test
    public void testPay() throws Exception {
        ItemDTO testItem = inventory.getItemInfo(1);
        ItemDTO testItem2 = inventory.getItemInfo(2);
        ItemDTO testItem3 = inventory.getItemInfo(3);
        sale.addToSale(testItem, 1);
        sale.addToSale(testItem2, 3);
        sale.addToSale(testItem3, 1);
        Map<ItemDTO, Integer> items = sale.getItems();

        assertTrue("Items has not been added", items.containsKey(testItem));
        assertEquals("Item does not have the correct quantity", 3, (int) items.get(testItem2));
        int size = items.size();
        assertEquals("The number of items in the basket is not correct", 3, size);

        double expectedAmountToPay = testItem.getPrice();
        expectedAmountToPay += (testItem2.getPrice() * 3);
        expectedAmountToPay += testItem3.getPrice();
        expectedAmountToPay = expectedAmountToPay * (1 + (TAX / 100));
        double cash = 150;
        double expectedChange = cash - expectedAmountToPay;

        double amountToPay = sale.getTotalWithTax();
        assertEquals("Amount to pay has not been calculated correctly", expectedAmountToPay, amountToPay, 0.001);
        double change = sale.pay(cash);
        assertEquals("Cash amount is wrong", expectedChange, change, 0.001);
    }
}
