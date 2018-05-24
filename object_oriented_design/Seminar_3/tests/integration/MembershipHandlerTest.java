package integration;

import model.DiscountDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Linus on 2018-05-06.
 */
public class MembershipHandlerTest {
    private MembershipHandler membership;

    @Before
    public void setUp() throws Exception {
        membership = new MembershipHandler();

    }

    @After
    public void tearDown() throws Exception {
        membership = null;

    }

    @Test
    public void testGetDiscount() throws Exception {
        DiscountDTO discount1 = membership.getEligibleDiscount(1);
        DiscountDTO discount1Clone = membership.getEligibleDiscount(1);
        DiscountDTO discount2 = membership.getEligibleDiscount(2);

        boolean discount1EqualWithClone = discount1.equals(discount1Clone);
        assertTrue("Discount fetched with identical ids are not the same!", discount1EqualWithClone);

        boolean discount1EqualWithDiscount2 = discount1.equals(discount2);
        assertFalse("Discount fetched with different ids are the same!", discount1EqualWithDiscount2);
    }

    @Test
    public void testConsumeDiscount() throws Exception{
        membership.consumeDiscount(1);
        assertNull("Discount is not removed correctly", membership.getEligibleDiscount(1));
    }
}
