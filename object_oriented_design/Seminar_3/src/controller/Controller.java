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
    private InventoryHandler inventory;
    private MembershipHandler memberships;

    public Controller(){
        this.inventory = new InventoryHandler();
        this.memberships = new MembershipHandler();
    }

    public void startSale(){
        this.currentSale = new Sale();
    }

    public ItemDTO enterItem(int itemId, int quantity){
        ItemDTO item = inventory.getItemInfo(itemId);
        this.currentSale.addToSale(item, quantity);
        return item;
    }

    //Return total with taxes
    public double completeSale(){
        double finalPrice = currentSale.getTotalWithTax();
        Map<ItemDTO, Integer> items = currentSale.getItems();
        for (Map.Entry<ItemDTO, Integer> entry : items.entrySet()){
            //Doesn't handle case where cashier tries to remove more items than are in stock
            inventory.removeFromStock(entry.getKey().getItemId(), entry.getValue());
        }
        return finalPrice;
    }

    //Return new total with taxes
    public double getCustomerDiscount(int memberId){
        DiscountDTO discount = memberships.getEligibleDiscount(memberId);
        return currentSale.applyDiscount(discount);
    }

    //Return amount of change to give to customer
    public double registerPayment(double payment){
        double change = currentSale.pay(payment);
        Printer.printReceipt(currentSale.getSaleInfo());
        return change;
    }

    public double getCurrentTotal(){
        return currentSale.getTotalWithTax();
    }

}
