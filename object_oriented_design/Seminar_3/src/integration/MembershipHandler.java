package integration;

import model.DiscountDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class MembershipHandler {
    private Map<Integer, DiscountDTO> discountDB;

    /**
     * Creates instance of object and initiates a "Database" of items, each with 10 in stock
     */
    public MembershipHandler(){
        discountDB = new HashMap<>();
        discountDB.put(1, new DiscountDTO(15, "2018-06-21"));
        discountDB.put(2, new DiscountDTO(20, "2018-07-21"));
        discountDB.put(3, new DiscountDTO(10, "2018-08-21"));
        discountDB.put(4, new DiscountDTO(35, "2018-09-21"));
        discountDB.put(5, new DiscountDTO(5, "2018-10-21"));
        discountDB.put(6, new DiscountDTO(15, "2018-11-21"));
    }

    /**
     * Returns the discount that the customer is eligible for
     *
     * @param memberId int
     * @return DiscountDTO
     */
    public DiscountDTO getEligibleDiscount(int memberId){
        return this.discountDB.get(memberId);
    }

    /**
     * Consumes (Deletes) the discount the customer was eligible for
     *
     * @param memberId int
     */
    public void consumeDiscount(int memberId){
        this.discountDB.remove(memberId);
    }
}
