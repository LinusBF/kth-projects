package model;

import integration.InventoryHandler;
import integration.ItemDTO;
import integration.MembershipHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Linus on 2018-05-06.
 */
public class SaleInfoTest {
    private InventoryHandler inventory;
    private MembershipHandler membership;
    private SaleInfo testSaleInfo;

    @Before
    public void setUp() throws Exception {
        inventory = new InventoryHandler();
        membership = new MembershipHandler();
        testSaleInfo = new SaleInfo();
    }

    @After
    public void tearDown() throws Exception {
        inventory = null;
        membership = null;
        testSaleInfo = null;
    }

    @Test
    public void testAddingItems() throws Exception {
        ItemDTO item1 = inventory.getItemInfo(1);
        ItemDTO item2 = inventory.getItemInfo(2);
        ItemDTO item3 = inventory.getItemInfo(3);

        testSaleInfo.addItem(item1, 1);
        assertEquals("Adding an item to SaleInfo doesn't add it to item Map", 1, testSaleInfo.getItems().size());

        testSaleInfo.addItem(item2, 1);
        assertEquals("Adding an additional item to SaleInfo doesn't add it to item Map", 2, testSaleInfo.getItems().size());

        testSaleInfo.addItem(item1, 5);
        assertEquals("Adding an already existing item does not handle the Map correctly", 2, testSaleInfo.getItems().size());

        testSaleInfo.addItem(item3, 3);
        assertEquals("Adding multiple of a new item doesn't work correctly", 3, testSaleInfo.getItems().size());
    }

    @Test
    public void testGetTotal() throws Exception {
        ItemDTO item1 = inventory.getItemInfo(1);
        ItemDTO item2 = inventory.getItemInfo(2);
        ItemDTO item3 = inventory.getItemInfo(3);

        double expectedCurrentTotal = 0;

        testSaleInfo.addItem(item1, 1);
        expectedCurrentTotal += item1.getPrice();
        assertEquals("Adding an item to SaleInfo doesn't add it to new total correctly", expectedCurrentTotal, testSaleInfo.getTotal(), 0.001);

        testSaleInfo.addItem(item2, 1);
        expectedCurrentTotal += item2.getPrice();
        assertEquals("Adding an additional item to SaleInfo doesn't update the total correctly", expectedCurrentTotal, testSaleInfo.getTotal(), 0.001);

        testSaleInfo.addItem(item1, 5);
        expectedCurrentTotal += item1.getPrice() * 5;
        assertEquals("Adding an already existing item does not update the total correctly", expectedCurrentTotal, testSaleInfo.getTotal(), 0.001);

        testSaleInfo.addItem(item3, 3);
        expectedCurrentTotal += item3.getPrice() * 3;
        assertEquals("Adding multiple of a new item doesn't update the total correctly", expectedCurrentTotal, testSaleInfo.getTotal(), 0.001);
    }

    @Test
    public void testApplyingDiscount() throws Exception {
        ItemDTO item1 = inventory.getItemInfo(1);
        ItemDTO item2 = inventory.getItemInfo(2);
        DiscountDTO discount1 = membership.getEligibleDiscount(1);
        DiscountDTO discount2 = membership.getEligibleDiscount(2);

        double expectedCurrentTotal = 0;
        double expectedCurrentTotalWithDiscount;

        testSaleInfo.setDiscount(discount1);

        testSaleInfo.addItem(item1, 1);
        expectedCurrentTotal += item1.getPrice();
        expectedCurrentTotalWithDiscount = calcTotalWithDiscount(expectedCurrentTotal, discount1);
        assertEquals("Adding an item to SaleInfo doesn't add it to new total correctly", expectedCurrentTotalWithDiscount, testSaleInfo.getTotal(), 0.001);

        testSaleInfo.addItem(item2, 1);
        expectedCurrentTotal += item2.getPrice();
        expectedCurrentTotalWithDiscount = calcTotalWithDiscount(expectedCurrentTotal, discount1);
        assertEquals("Adding an additional item to SaleInfo doesn't update the discounted total correctly", expectedCurrentTotalWithDiscount, testSaleInfo.getTotal(), 0.001);

        testSaleInfo.addItem(item1, 5);
        expectedCurrentTotal += item1.getPrice() * 5;
        expectedCurrentTotalWithDiscount = calcTotalWithDiscount(expectedCurrentTotal, discount1);
        assertEquals("Adding an already existing item does not update the discounted total correctly", expectedCurrentTotalWithDiscount, testSaleInfo.getTotal(), 0.001);


        testSaleInfo.setDiscount(discount2);
        expectedCurrentTotalWithDiscount = calcTotalWithDiscount(expectedCurrentTotal, discount2);
        assertEquals("Changing the applied discount doesn't change the discounted total correctly", expectedCurrentTotalWithDiscount, testSaleInfo.getTotal(), 0.001);

    }

    private double calcTotalWithDiscount(double expectedTotal, DiscountDTO discount){
        return expectedTotal * ((100 - discount.getPercentage()) / 100);
    }
}
