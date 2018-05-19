package controller;

import exceptions.DatabaseFailureException;
import exceptions.ItemNotFoundException;
import exceptions.OperationFailedException;
import integration.InventoryHandler;
import integration.ItemDTO;
import integration.MembershipHandler;
import integration.Printer;
import model.DiscountDTO;
import model.Sale;
import model.SaleObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Linus on 2018-05-05.
 */
public class Controller {
    private Sale currentSale = null;
    private int currentMemberId = -1;
    private InventoryHandler inventory;
    private MembershipHandler memberships;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * @param inv InventoryHandler
     * @param mem MembershipHandler
     */
    public Controller(InventoryHandler inv, MembershipHandler mem){
        this.inventory = inv;
        this.memberships = mem;
    }

    /**
     * Initiates a sale
     */
    public void startSale(){
        this.currentSale = new Sale();
        this.currentSale.addSaleObservers(saleObservers);
    }

    /**
     * Adds an item to the current sale
     *
     * @param itemId int
     * @param quantity int
     * @return ItemDTO
     */
    public ItemDTO enterItem(int itemId, int quantity) throws ItemNotFoundException, OperationFailedException {
        try{
            ItemDTO item = inventory.getItemInfo(itemId);
            this.currentSale.addToSale(item, quantity);
            return item;
        }catch (DatabaseFailureException e){
            throw new OperationFailedException("Could not get the item.", e);
        }
    }

    /**
     * Returns total with taxes
     *
     * @return double
     */
    public double completeSale(){
        return currentSale.getTotalWithTax();
    }

    /**
     * Returns new total with taxes
     *
     * @param memberId int
     * @return double
     */
    public double getCustomerDiscount(int memberId){
        DiscountDTO discount = memberships.getEligibleDiscount(memberId);
        this.currentMemberId = memberId;
        return currentSale.applyDiscount(discount);
    }

    /**
     * Returns amount of change to give to customer
     * Removes the purchased items from the inventory and consumes any potential discounts
     *
     * @param payment double
     * @return double
     */
    public double completePayment(double payment){
        double change = currentSale.pay(payment);
        Map<ItemDTO, Integer> items = currentSale.getItems();
        for (Map.Entry<ItemDTO, Integer> entry : items.entrySet()){
            //Doesn't handle case where cashier tries to remove more items than are in stock
            inventory.removeFromStock(entry.getKey().getItemId(), entry.getValue());
        }
        if(this.currentMemberId > 0){
            memberships.consumeDiscount(currentMemberId);
            this.currentMemberId = -1;
        }
        Printer.printReceipt(currentSale.getSaleInfo());
        return change;
    }

    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }

    /**
     * @return double
     */
    public double getCurrentTotal(){
        return currentSale.getTotalWithTax();
    }

}
