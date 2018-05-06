package controller;

import integration.InventoryHandler;
import integration.ItemDTO;
import integration.MembershipHandler;
import integration.Printer;
import model.DiscountDTO;
import model.Sale;

import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class Controller {
    private Sale currentSale = null;
    private int currentMemberId = -1;
    private InventoryHandler inventory;
    private MembershipHandler memberships;

    public Controller(InventoryHandler inv, MembershipHandler mem){
        this.inventory = inv;
        this.memberships = mem;
    }

    //Initiates a sale
    public void startSale(){
        this.currentSale = new Sale();
    }

    //Adds an item to the current sale
    public ItemDTO enterItem(int itemId, int quantity){
        ItemDTO item = inventory.getItemInfo(itemId);
        this.currentSale.addToSale(item, quantity);
        return item;
    }

    //Removes the purchased items from the inventory and expends any potential discounts
    //Returns total with taxes
    public double completeSale(){
        double finalPrice = currentSale.getTotalWithTax();
        Map<ItemDTO, Integer> items = currentSale.getItems();
        for (Map.Entry<ItemDTO, Integer> entry : items.entrySet()){
            //Doesn't handle case where cashier tries to remove more items than are in stock
            inventory.removeFromStock(entry.getKey().getItemId(), entry.getValue());
        }
        if(this.currentMemberId > 0){
            memberships.expendDiscount(currentMemberId);
            this.currentMemberId = -1;
        }
        return finalPrice;
    }

    //Returns new total with taxes
    public double getCustomerDiscount(int memberId){
        DiscountDTO discount = memberships.getEligibleDiscount(memberId);
        this.currentMemberId = memberId;
        return currentSale.applyDiscount(discount);
    }

    //Returns amount of change to give to customer
    public double registerPayment(double payment){
        double change = currentSale.pay(payment);
        Printer.printReceipt(currentSale.getSaleInfo());
        return change;
    }

    public double getCurrentTotal(){
        return currentSale.getTotalWithTax();
    }

}
